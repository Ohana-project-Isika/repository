package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.Order;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.PaymentService;
import fr.isika.cda11.ohana.project.event.controller.EventController;
import fr.isika.cda11.ohana.project.event.models.MeansOfPayment;
import lombok.Getter;
import lombok.Setter;

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

    private UIComponent component;
    private String url;
    private boolean isPaying;

    @ManagedProperty(value="#{eventController}")
    private EventController eventController;

    private MeansOfPayment meansOfPayment;
    private String cardNumber;
    private String fullName;
    private String expiry;
    private String cvc;
    private Order order;
    private Date minExpiry = setMinExpiry();

    public String pay() {
        order = eventController.getCart();
        System.out.println(order);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) == null) {
            isPaying = true;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Vous devez d'abord vous connecter pour " +
                    "poursuivre le paiement"));
            return "";
        } else {
            return "review";
        }
    }

    public String completePayment() {
        return "ticketing/completePayment.xhtml?faces-redirect=true";
    }

    public String validatePayment() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        AccountDto accountDto = accountService.findAccountByLogIn(session.getAttribute(ACCOUNT_ATTRIBUTE).toString());
        accountDto.addOrder(order);

        accountService.updateAccount(accountDto);

        return "ticketing/validatePayment";
    }

    public String backToTicketing() {
        return "ticketing?faces-redirect=true";
    }

    public String backToCart() {
        return "ticketing/checkout?faces-redirect=true";
    }

    public Date setMinExpiry() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }
}
