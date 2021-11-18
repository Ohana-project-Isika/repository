package fr.isika.cda11.ohana.project.common.repository;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LoginRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Account> validateAccount(String username, String password) {
        Query query = entityManager.createQuery("SELECT DISTINCT a FROM Account a WHERE a.accountLogin = :username AND a.accountPassword = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);

        return query.getResultList();
    }
}
