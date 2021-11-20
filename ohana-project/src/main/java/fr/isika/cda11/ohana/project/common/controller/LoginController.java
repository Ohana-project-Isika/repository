package fr.isika.cda11.ohana.project.common.controller;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.service.LoginService;
import lombok.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

import static fr.isika.cda11.ohana.project.common.models.Constant.*;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class LoginController implements Serializable {

    @Inject
    private LoginService loginService;

    @ManagedProperty(value="#{paymentController}")
    private PaymentController paymentController;

    private String loggedUser;
    private Account account = new Account();

    public String validateLogin() {
        if (loginService.validateAccount(account.getAccountLogin(), account.getAccountPassword())) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                    .getSession(false);
            session.setAttribute(ACCOUNT_ATTRIBUTE, account.getAccountLogin());
            session.setAttribute(ACCOUNT_CONNECTED, true);
            setLoggedUser();
            resetLoginData();

            if (paymentController.isPaying()) {
                paymentController.setPaying(false);
                return "ticketing/checkout";
            } else
                return "logged";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Veuillez vérifier vos coordonnées", "Saisissez un identifiant ou un mot de passe correct"));
            return "login";
        }
    }

    private void setLoggedUser() {
        this.loggedUser = account.getAccountLogin();
    }

    public String logIn() { return "login"; }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        resetLoginData();
        clearLoggedUser();
        return "login?faces-redirect=true";
    }

    private void clearLoggedUser() {
        this.loggedUser = "";
    }

    private void resetLoginData() {
        account = new Account();
    }
}
