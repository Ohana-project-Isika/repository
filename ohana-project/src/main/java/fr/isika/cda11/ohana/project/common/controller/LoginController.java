package fr.isika.cda11.ohana.project.common.controller;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;
import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_CONNECTED;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.common.service.LoginService;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5229904843001879431L;
	@Inject
	private LoginService loginService;
	@Inject
	private AccountService accountService;
	@Inject
	private AssociationService assosService;
	@Inject
	private DashboardAssociationController dashboardAssociationController;

	private String loggedUser;
	private Boolean isConnected = false;
	private AccountDto accountDto = new AccountDto();
	private AssociationDto associationDto = new AssociationDto();

	public String validateLogin() {
		Optional<AccountDto> optional = accountService.findByLoginAndPassword(accountDto.getAccountLogin(), accountDto.getAccountPassword());
		if(optional.isPresent()) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			
			accountDto = optional.get();
			
			session.setAttribute(ACCOUNT_ATTRIBUTE, accountDto.getIdAccount());
			session.setAttribute(ACCOUNT_CONNECTED, true);
			
			setLoggedUser();
			setConnected();
			
			if (accountDto.getRole().equals(EnumRole.PRIVATEPERSON)) {

				return "indexOhana";
			}
			else if(accountDto.getRole().equals(EnumRole.ASSOCIATION)) {
				List<AssociationDto> assos = new ArrayList<AssociationDto>();
				assos=assosService.listAssociationsService();
				for(AssociationDto association : assos) {
					if(association.getAccount().getIdAccount()==accountDto.getIdAccount()) {
						associationDto=association;
					}
				}
				return dashboardAssociationController.ReadListMemberByAssociation(associationDto.getIdAssos());
			}

			return "logged";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Veuillez vérifier vos coordonnées", "Saisissez un identifiant ou un mot de passe correct"));
			return "login";
		}
	}

	public String viewParamLogged() {
		return (loggedUser != null) ? "Bienvenue " + loggedUser : "CONNECTEZ-VOUS";
	}
	public String connexion() {
		return (isConnected) ? logout() : "login?faces-redirect=true";
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		resetLoginData();
		clearLoggedUser();
		isConnected = false;
		loggedUser = null;
		return "indexOhana?faces-redirect=true";
	}

	public Boolean isConnected() {
		return isConnected;
	}

	private void setLoggedUser() {
		this.loggedUser = accountDto.getAccountLogin();
	}

	private void setConnected() {
		isConnected = true;
	}
	
	private void clearLoggedUser() {
		this.loggedUser = "";
	}

	private void resetLoginData() {
		accountDto = new AccountDto();
	}

}

