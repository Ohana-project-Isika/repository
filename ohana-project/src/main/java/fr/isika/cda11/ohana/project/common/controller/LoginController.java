//package fr.isika.cda11.ohana.project.common.controller;
//
//import fr.isika.cda11.ohana.project.common.models.Account;
//
//import javax.annotation.ManagedBean;
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import javax.inject.Named;
//import javax.servlet.http.HttpSession;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.logging.Logger;
//
//@ManagedBean
//@Named
//@SessionScoped
//public class LoginController implements Serializable {
//
//	private static final long serialVersionUID = -8909946113527401859L;
//	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getSimpleName());
//
//	private static final String LOGIN = "test";
//	private static final byte[] HASHED_PASSWORD = Base64.getDecoder().decode("test".getBytes());
//
//	private String loggedUser;
//	private Account account = new Account();
//
//	public LoginController() {
//		LOGGER.info("Constructor call ...");
//	}
//
//	@PostConstruct
//	private void init() {
//		LOGGER.info("Init call ...");
//		fillTestLoginValues();
//	}
//
//	public String validateLogin() {
//		if (areLoginDataValid()) {
//			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
//					.getSession(false);
//			session.setAttribute("loggedUser", user.getUserName());
//			session.setAttribute("connected", true);
//			setLoggedUser();
//			resetLoginData();
//			return "logged?faces-redirect=true";
//		} else {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
//					"Please check your login information", "Enter correct login and password"));
//			return "login?faces-redirect=true";
//		}
//	}
//
//	private void setLoggedUser() {
//		this.loggedUser = user.getUserName();
//	}
//
//	public String logout() {
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		session.invalidate();
//		resetLoginData();
//		clearLoggedUser();
//		return "login?faces-redirect=true";
//	}
//
//	/*
//	 * Helpers
//	 */
//	private boolean areLoginDataValid() {
//		return LOGIN.equals(user.getUserName()) && Arrays.equals(HASHED_PASSWORD, user.getEncodedPassword());
//	}
//
//	private void fillTestLoginValues() {
//		 this.user = new UserDto("test", "test");
//	}
//
//	private void clearLoggedUser() {
//		this.loggedUser = "";
//	}
//
//	private void resetLoginData() {
//		this.user = new UserDto();
//	}
//
//	/*
//	 * Getters and setters
//	 */
//	public UserDto getUser() {
//		return user;
//	}
//
//	public void setUser(UserDto user) {
//		this.user = user;
//	}
//
//	public String getLoggedUser() {
//		return loggedUser;
//	}
//
//}
