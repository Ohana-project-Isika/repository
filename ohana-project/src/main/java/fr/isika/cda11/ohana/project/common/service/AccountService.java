package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.repository.AccountRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AccountService {

    @Inject
    private AccountRepository accountRepository;

    public AccountDto findAccountByLogIn(String logIn) {
        return accountRepository.findAccountByLogin(logIn);
    }

    public AccountDto updateAccount(AccountDto accountDto) {
        accountRepository.updateAccount(accountDto);

        return findAccountByLogIn(accountDto.getAccountLogin());
    }
}
