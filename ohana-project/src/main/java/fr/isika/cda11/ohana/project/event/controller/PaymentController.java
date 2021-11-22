package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.common.controller.LoginController;
import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.PrivatePersonService;
import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.service.PaymentService;
import fr.isika.cda11.ohana.project.event.service.TicketService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class PaymentController implements Serializable {

    @Inject
    private PaymentService paymentService;

    @Inject
    private AccountService accountService;

    @Inject
    private PrivatePersonService privatePersonService;

    @Inject
    private TicketService ticketService;

    private UIComponent component;
    private String url;
    private boolean isPaying;

    @ManagedProperty(value="#{eventController}")
    private EventController eventController;

    private String cardNumber;
    private String fullName;
    private String expiry;
    private String cvc;
    private Order order;
    private Date minExpiry = setMinExpiry();
    private Long loggedInUser;

    public String pay() {
        order = eventController.getCart();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) == null) {
            isPaying = true;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Vous devez d'abord vous connecter pour " +
                    "poursuivre le paiement"));
            return "";
        } else {
            return "verificationPanier";
        }
    }

    public String completePayment() {
        return "completePayment";
    }

    public String validatePayment() {

        AccountDto accountDto = accountService.findAccountByIdService(loggedInUser);
        PrivatePersonDto privatePersonDto = privatePersonService.findPrivatePersonByAccount(accountDto);

        order.getTicketsByIds().forEach((key, value) -> {
            value.setPrivatePerson(PrivatePersonFactory.fromPrivatePersonDto(privatePersonDto));
            ticketService.update(value);
            privatePersonDto.addTicket(value);
        });
        privatePersonService.updatePrivatePerson(privatePersonDto);

        return "validatePayment";
    }

    public String backToCart() {
        return "reservation";
    }

    public Date setMinExpiry() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }
}
