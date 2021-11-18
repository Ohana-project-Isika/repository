package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.models.Order;
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

    private String cartSubTotal;
    private String cartTotal;
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
    private Order order = new Order();

    public String pay(Order cart) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) == null) {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(component.getClientId(), new FacesMessage("Vous devez d'abord vous connecter pour " +
//                    "poursuivre le paiement"));
            isPaying = true;
            return "login";
        }
        else if (session.getAttribute(ACCOUNT_ATTRIBUTE) != null)
            return "login";
        else {
//            FacesContext con = FacesContext.getCurrentInstance();
//            con.addMessage(component.getClientId(), new FacesMessage("Une erreur s'est produite, veuillez nous contactez"));
            return "error";
        }
    }

    public String continuePayment(Order cart) {
        this.order = cart;
        return "ticketing/payment?faces-redirect=true";
    }

    public String completePayment() {
        return "ticketing/completePayment.xhtml?faces-redirect=true";
    }

    public String validatePayment() {
        paymentService.save(order);
        return "ticketing/validatePayment?faces-redirect=true";
    }

    public String back() {
        return "ticketing?faces-redirect=true";
    }
}
