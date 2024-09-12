package fr.isika.cda11.ohana.project.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.google.protobuf.Option;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.repository.AccountRepos;
import fr.isika.cda11.ohana.project.common.repository.ContactRepos;
import fr.isika.cda11.ohana.project.common.repository.InfoPersonRepos;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;


@Stateless
public class AccountService {


		@Inject
		private AccountRepos accountRepos;
		
		@Inject 
		private InfoPersonRepos infoPersonRepos;
		
		@Inject
		private ContactRepos contactRepos;
		
		//CREATE
		public AccountDto createAccountervice(AccountDto accountDto, InfoPersonDto infoPersonDto, ContactDto contactDto, AddressDto addressDto) {
			infoPersonDto.setContact(contactDto);
			infoPersonDto.setAddress(addressDto);
			accountDto.setAccountCreationDate(new Date());
			accountDto.setInfoPerson(infoPersonDto);
			Account newAccount= accountRepos.createAccountRepos(accountDto);
			AccountDto newAccountDto= AccountFactory.fromAccount(newAccount);
			return findAccountByIdService(Long.valueOf(newAccountDto.getIdAccount()));
		}
		
		//READ
		public AccountDto findAccountByIdService(Long id) {
			return accountRepos.findAccountByIdRepos(id);
		}

		public List<AccountDto> listAccountService() {
			return accountRepos.listAccountRepos();
		}
		
		public Optional<AccountDto> findByLoginAndPassword(String login, String password) {
			return accountRepos.findByLoginAndPassword(login, password);
		}
		
		//UPDATE
		public AccountDto updateAccountService(AccountDto accountDto) {
			accountRepos.updateAccountRepos(accountDto);
			return findAccountByIdService(accountDto.getIdAccount());
		}

		//DELETE
		public void deleteAccountService(Long id) {
			accountRepos.deleteAccountRepos(id);
		}
}