package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.models.Account;


@Stateless
public class AccountRepos {
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createAccountRepos(AccountDto accountDto) {
		Account account = AccountFactory.fromAccountDto(accountDto);
		entityManager.persist(account);
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
}
