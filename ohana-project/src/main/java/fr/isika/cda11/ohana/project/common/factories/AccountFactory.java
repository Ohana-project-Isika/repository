package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.models.Account;

public class AccountFactory {

    public static Account fromAccountDto(AccountDto accountDto) {
        Account account = new Account();

        account.setAccountLogin(accountDto.getAccountLogin());
        account.setAccountPassword(accountDto.getAccountPassword());
        account.setAccountCreationDate(accountDto.getAccountCreationDate());
        account.setRole(accountDto.getRole());

        return account;
    }

    public static AccountDto fromAccount(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setAccountLogin(account.getAccountLogin());
        accountDto.setAccountPassword(account.getAccountPassword());
        accountDto.setAccountCreationDate(account.getAccountCreationDate());
        accountDto.setRole(account.getRole());

        return accountDto;
    }
}
