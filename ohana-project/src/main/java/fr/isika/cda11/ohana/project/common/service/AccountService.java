package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.repository.AccountRepos;
import fr.isika.cda11.ohana.project.common.repository.ContactRepos;
import fr.isika.cda11.ohana.project.common.repository.InfoPersonRepos;


@Stateless
public class AccountService {


		@Inject
		private AccountRepos accountRepos;
		
		@Inject 
		private InfoPersonRepos infoPersonRepos;
		
		@Inject
		private ContactRepos contactRepos;
		
		//CREATE
		public void createAccountervice(AccountDto accountDto, InfoPersonDto infoPersonDto, ContactDto contactDto, AddressDto addressDto) {

			infoPersonDto.setContact(contactDto);
			infoPersonDto.getAddress().add(addressDto);
			accountDto.setInfoPerson(infoPersonDto);
			accountRepos.createAccountRepos(accountDto);
		}
		
		//READ
		public AccountDto findAccountByIdService(long id) {
			return accountRepos.findAccountByIdRepos(id);
		}

		public List<AccountDto> listAccountService() {
			return accountRepos.listAccountRepos();
		}
		
		//UPDATE
		public AccountDto updateAccountService(AccountDto accountDto) {
			accountRepos.updateAccountRepos(accountDto);
			return findAccountByIdService(accountDto.getIdAccount());
		}

		//DELETE
		public void deleteAccountService(long id) {
			accountRepos.deleteAccountRepos(id);
		}
}
