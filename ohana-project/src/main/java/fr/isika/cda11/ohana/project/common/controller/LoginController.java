package fr.isika.cda11.ohana.project.common.controller;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.service.LoginService;
import lombok.*;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Logger;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;
import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_CONNECTED;

@ManagedBean
@Named
@SessionScoped
@Getter
@Setter
public class LoginController implements Serializable {

	@Inject
	private LoginService loginService;

	private String loggedUser;
	private Account account = new Account();

	public String validateLogin() {
		if (loginService.isLoginValid(account.getUsername(), account.getPassword())) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute(ACCOUNT_ATTRIBUTE, account.getUsername());
			session.setAttribute(ACCOUNT_CONNECTED, true);
			setLoggedUser();
			resetLoginData();
			return "logged?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Veuillez vérifier vos coordonnées", "Saisissez un identifiant ou un mot de passe correct"));
			return "login?faces-redirect=true";
		}
	}

	private void setLoggedUser() {
		this.loggedUser = account.getUsername();
	}

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
