package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.models.Account;


@Stateless
public class AccountRepos {
	private static final String SELECT_ACCOUNT_BY_LOGIN_AND_PASSWORD = "SELECT a FROM Account a WHERE a.accountLogin =: loginParam AND a.accountPassword =: pwdParam";
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public Account createAccountRepos(AccountDto accountDto) {
		Account account = AccountFactory.fromAccountDto(accountDto);
		entityManager.persist(account);
		return account;
	}

	//READ
	public AccountDto findAccountByIdRepos(Long id) {

		AccountDto accountDto= AccountFactory.fromAccount(entityManager.find(Account.class, id));	
		return accountDto;
	}

	public List<AccountDto> listAccountRepos(){
		return this.entityManager.createNamedQuery("account.findAll", Account.class).getResultList().stream().map(account -> AccountFactory.fromAccount(account)).collect(Collectors.toList());
	}

	//UPDATE
	public Account updateAccountRepos(AccountDto accountToUpdate) {
		Account account = AccountFactory.fromAccountDto(accountToUpdate);
		return entityManager.merge(account);
	}

	//DELETE

	public void deleteAccountRepos(Long id) {
		Account account = entityManager.find(Account.class, id);
		if(account != null) {
			entityManager.remove(account);
		}
	}

	public Optional<AccountDto> findByLoginAndPassword(String login, String password) {
		Account account = this.entityManager.createQuery(SELECT_ACCOUNT_BY_LOGIN_AND_PASSWORD, Account.class)
				.setParameter("loginParam", login)
				.setParameter("pwdParam", password)
				.getSingleResult();
		if(account != null) {
			return Optional.of(AccountFactory.fromAccount(account));
		}
		return Optional.empty();
	}
}
