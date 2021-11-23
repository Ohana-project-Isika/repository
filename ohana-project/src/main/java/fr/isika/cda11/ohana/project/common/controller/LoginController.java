package fr.isika.cda11.ohana.project.common.controller;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.LoginService;
import fr.isika.cda11.ohana.project.event.controller.PaymentController;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;
import lombok.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;
import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_CONNECTED;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class LoginController implements Serializable {

    @Inject
    private LoginService loginService;
    @Inject
    private AccountService accountService;

    @ManagedProperty(value="#{paymentController}")
    private PaymentController paymentController;

    private Long loggedUser;
    private Account account = new Account();
    private AccountDto accountDto= new AccountDto();
 private Boolean isConnected = false;
    
    

    public String validateLogin() {
        account = loginService.validateLogin(account.getAccountLogin(), account.getAccountPassword());
        setLoggedUser();
        if (account != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                    .getSession(false);
            session.setAttribute(ACCOUNT_ATTRIBUTE, account.getIdAccount());
            session.setAttribute(ACCOUNT_CONNECTED, true);
            System.out.println("logeduser1="+loggedUser);
            System.out.println(account.getAccountLogin());
            List<AccountDto> accounts = new ArrayList<AccountDto>();
            AccountDto accountconnected=new AccountDto();
            accounts = accountService.listAccountService();
            isConnected();
            for(AccountDto accountdto: accounts) {
            	if(accountdto.getAccountLogin().equals(account.getAccountLogin()) && accountdto.getAccountPassword().equals(account.getAccountPassword())){
                   accountconnected= accountdto;
            	}
            }
            System.out.println(accountconnected.getIdAccount()+"/"+accountconnected.getRole());
            if(accountconnected.getRole().equals(EnumRole.PRIVATEPERSON)) {
            	 resetLoginData();
            	 System.out.println("loogeduser2= "+loggedUser);
            	 accountDto=accountconnected;
            	return "indexOhana";
            }
            resetLoginData();

            if (paymentController.isPaying()) {
                paymentController.setPaying(false);
                return "reservation";
            } else
                return "logged";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Veuillez vérifier vos coordonnées", "Saisissez un identifiant ou un mot de passe correct"));
            return "login";
        }
    }

    private void setLoggedUser() {

        loggedUser = account.getIdAccount();
        paymentController.setLoggedInUser(loggedUser);
    }

public String viewParamLogged() {
	if(loggedUser!=null) {
		return "Bienvenue "+loggedUser;
	}
	
	else 
		return "CONNECTEZ-VOUS";
}
public String outcomeLogged() {
	if(loggedUser!=null) {
		return "#{loginController.logout()}";
	}
	else {
		return "#{loginController.openLogin()}";
	}
}

public Boolean isConnected() {
	isConnected=true;
	
	return isConnected;
}

public String openLogin() {
	return "login?faces-redirect-true";
}
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        resetLoginData();
        clearLoggedUser();
        isConnected=false;
        loggedUser=null;
        return "indexOhana";
    }

    private void clearLoggedUser() {
        paymentController.setLoggedInUser(null);
        loggedUser = null;
    }

    private void resetLoginData() {
        account = new Account();
    }

    public String logIn() { return "login"; }
}
