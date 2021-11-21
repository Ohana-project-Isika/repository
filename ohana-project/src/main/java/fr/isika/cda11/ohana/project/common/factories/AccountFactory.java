package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.models.Account;


public class AccountFactory {
	private AccountFactory() {
		
	}

	
	public static Account fromAccountDto(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountLogin(accountDto.getAccountLogin());
		account.setAccountPassword(accountDto.getAccountPassword());
		account.setRole(accountDto.getRole());
		account.setAccountCreationDate(accountDto.getAccountCreationDate());
		account.setInfoPerson(InfoPersonFactory.fromInfoPersonDto(accountDto.getInfoPerson()));
		account.setIdAccount(accountDto.getIdAccount());

		return account;
	}
	
	public static AccountDto fromAccount(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountLogin(account.getAccountLogin());
		accountDto.setAccountPassword(account.getAccountPassword());
		accountDto.setRole(account.getRole());
		accountDto.setAccountCreationDate(account.getAccountCreationDate());
		accountDto.setInfoPerson(InfoPersonFactory.fromInfoPerson(account.getInfoPerson()));
		accountDto.setIdAccount(Long.valueOf(account.getIdAccount()));

		return accountDto;
	}
}
