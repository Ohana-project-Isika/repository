package fr.isika.cda11.ohana.project.common.controller;

import com.paypal.base.rest.PayPalRESTException;
import fr.isika.cda11.ohana.project.common.models.Cart;
import fr.isika.cda11.ohana.project.common.models.OrderDetail;
import fr.isika.cda11.ohana.project.common.models.PaymentServices;
import fr.isika.cda11.ohana.project.common.service.AuthorizePaymentService;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class AuthorizePaymentController implements Serializable {

    @Inject
    private AuthorizePaymentService authorizePaymentService;

    private String cartSubTotal;
    private String cartTotal;
    private UIComponent component;

    public String pay(Cart cart) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Vous devez d'abord vous connecter pour " +
                    "poursuivre le paiement"));
        }

        String product = Long.toString(cart.getId());
        String subtotal = "10";
        String shipping = "0";
        String quantity = "" + cart.getEvents().size();
        String tax = "0.55";
        String total = "10.55";

        System.out.println(subtotal + " " + tax);

        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);

        System.out.println("ffff" + orderDetail.getTotal() + " " + orderDetail.getTax() + orderDetail.getSubtotal());

        try {
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);

            return "https://www.paypal.com/sdk/js?client-id=AX-azce-xi8k1iprgyUpHzMdtCC6XyefgvcrKSG8veczA0VZP_E3vdZ0zrtCv4OwjsGgWYA0Ut_kuhPg";

        } catch (PayPalRESTException ex) {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(component.getClientId(), new FacesMessage(ex.getMessage()));
            ex.printStackTrace();

            return "error?faces-redirect=true";
        }
    }
}
