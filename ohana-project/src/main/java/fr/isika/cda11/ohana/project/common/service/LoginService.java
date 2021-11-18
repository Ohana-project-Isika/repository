package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.repository.LoginRepository;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import java.io.Serializable;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;
import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_CONNECTED;

@Stateless
public class LoginService implements Serializable {

    @Inject
    private LoginRepository loginRepository;

    public void isLoggedIn(Account account) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        session.setAttribute(ACCOUNT_ATTRIBUTE, account.getAccountLogin());
        session.setAttribute(ACCOUNT_CONNECTED, true);
    }

    public boolean isLoginValid(String username, String password) {
        for (Account a : loginRepository.validateAccount(username, password)) {
            if (username.equals(a.getAccountLogin()) && password.equals(a.getAccountPassword())) {
                return true;
            }
        }

        return false;
    }
}
