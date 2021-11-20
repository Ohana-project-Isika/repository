package fr.isika.cda11.ohana.project.common.repository;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.factories.AddressFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountDto findByLogIn(String logIn) {
        return AccountFactory.fromAccount(entityManager.find(Account.class, logIn));
    }

    public AccountDto findAccountByLogin(String login) {
        Query query = entityManager.createQuery("SELECT DISTINCT a FROM Account a WHERE a.accountLogin = :login");
        query.setParameter("login", login);

        return  AccountFactory.fromAccount((Account) query.getResultList().get(0));
    }

    public List<Account> findAllAccounts() {
        return entityManager.createNamedQuery("Accounts.findAll").getResultList();
    }

    public Account updateAccount(AccountDto accountDto) {
        Account account = AccountFactory.fromAccountDto(accountDto);
        return entityManager.merge(account);
    }
}
