package fr.isika.cda11.ohana.project.common.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import fr.isika.cda11.ohana.project.common.controller.PaymentController;
import fr.isika.cda11.ohana.project.common.models.Order;
import fr.isika.cda11.ohana.project.common.repository.PaymentRepository;
import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static fr.isika.cda11.ohana.project.common.models.Constant.*;

@Stateless
public class PaymentService {

    @Inject
    private PaymentRepository paymentRepository;

    public void capturePayPalAPI(Order cart) {

        /*
         * Flow would look like this:
         * 1. Create Payer object and set PaymentMethod
         * 2. Set RedirectUrls and set cancelURL and returnURL
         * 3. Set Details and Add PaymentDetails
         * 4. Set Amount
         * 5. Set Transaction
         * 6. Add Payment Details and set Intent to "authorize"
         * 7. Create APIContext by passing the clientID, secret and mode
         * 8. Create Payment object and get paymentID
         * 9. Set payerID to PaymentExecution object
         * 10. Execute Payment and get Authorization
         *
         */

        Payer payer = new Payer();
        payer.setPaymentMethod(PAYPAL);

        // Redirect URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/ohana-project/ticketing/cancel.xhtml");
        redirectUrls.setReturnUrl("http://localhost:8080/ohana-project/ticketing/return.xhtml");

        // Set Payment Details Object
        Details details = new Details();
        details.setShipping("0.00");
        details.setSubtotal("10.00");

        BigDecimal taxTotal = BigDecimal.ZERO;
        BigDecimal interest = BigDecimal.ZERO;
        BigDecimal preTaxTotal = BigDecimal.ZERO;
        for (Event event : cart.getEvents()) {
            interest = interest.add(event.getTicket().getPreTaxPrice().multiply(event.getTicket().getTvaRate())
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
            preTaxTotal = preTaxTotal.add(event.getTicket().getPreTaxPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        preTaxTotal = interest.divide(preTaxTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
        details.setTax(preTaxTotal.toString());

        // Set Payment amount
        Amount amount = new Amount();
        amount.setCurrency(USD);
        amount.setTotal("10.00");
        amount.setDetails(details);

        // Set Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(DESCRIPTION_ACHAT);
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        // Add Payment details
        Payment payment = new Payment();

        // Set Payment intent to authorize
        payment.setIntent(AUTH);
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        payment.setRedirectUrls(redirectUrls);

        // Pass the clientID, secret and mode. The easiest, and most widely used option.
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        try {

            Payment myPayment = payment.create(apiContext);

            System.out.println("createdPayment Obejct Details ==> " + myPayment.toString());

            // Identifier of the payment resource created
            payment.setId(myPayment.getId());

            PaymentExecution paymentExecution = new PaymentExecution();

            // Set your PayerID. The ID of the Payer, passed in the `return_url` by PayPal.
            paymentExecution.setPayerId(new PaymentController().getUrl());

            // This call will fail as user has to access Payment on UI. Programmatically
            // there is no way you can get Payer's consent.
            Payment createdAuthPayment = payment.execute(apiContext, paymentExecution);

            // Transactional details including the amount and item details.
            Authorization authorization = createdAuthPayment.getTransactions().get(0).getRelatedResources().get(0).getAuthorization();

            log("Here is your Authorization ID" + authorization.getId());

        } catch (PayPalRESTException e) {

            // The "standard" error output stream. This stream is already open and ready to
            // accept output data.
            System.err.println(e.getDetails());
        }
    }

    private void log(String string) {
        System.out.println(string);

    }

    public void save(Order order) {
        paymentRepository.save(order);
    }
}
