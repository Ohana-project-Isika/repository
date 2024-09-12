package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.util.EnumSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.InfoPersonService;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;

@ManagedBean
@SessionScoped
public class AccountController implements Serializable{

	//push test
	private static final long serialVersionUID = -1373993544070458079L;

	@Inject 
	AccountService accountService;
	@Inject
	InfoPersonService infoPersonService;

	//ATTRIBUTS
	EnumSet<EnumRole> rolesSet = EnumSet.of(EnumRole.PRIVATEPERSON, EnumRole.ASSOCIATION);
	private AccountDto newAccountDto = new AccountDto();
	private InfoPersonDto newInfoPersonDto = new InfoPersonDto();
	private ContactDto newContactDto = new ContactDto();
	private AddressDto newAddressDto = new AddressDto();
	private AccountDto accountnew= new AccountDto();

	public AccountService getAccountService() {return accountService;}
	public void setAccountService(AccountService accountService) {this.accountService = accountService;}
	public InfoPersonService getInfoPersonService() {return infoPersonService;}
	public void setInfoPersonService(InfoPersonService infoPersonService) {this.infoPersonService = infoPersonService;}
	public AccountDto getNewAccountDto() {return newAccountDto;}
	public void setNewAccountDto(AccountDto newAccountDto) {this.newAccountDto = newAccountDto;}
	public InfoPersonDto getNewInfoPersonDto() {return newInfoPersonDto;}
	public void setNewInfoPersonDto(InfoPersonDto newInfoPersonDto) {this.newInfoPersonDto = newInfoPersonDto;}
	public ContactDto getNewContactDto() {return newContactDto;}
	public void setNewContactDto(ContactDto newContactDto) {this.newContactDto = newContactDto;}
	public AddressDto getNewAddressDto() {return newAddressDto;}
	public void setNewAddressDto(AddressDto newAddressDto) {this.newAddressDto = newAddressDto;}
	public static long getSerialversionuid() {return serialVersionUID;}
	public EnumRole[] getRole() {
		EnumRole[] roles = new EnumRole[2];
		return rolesSet.toArray(roles);
	}
	public AccountDto getAccountnew() {
		return accountnew;
	}
	public void setAccountnew(AccountDto accountnew) {
		this.accountnew = accountnew;
	}

	//CREATE AN ACCOUNT
	public String createnewAccount() {
		accountnew= accountService.createAccountervice(newAccountDto, newInfoPersonDto, newContactDto, newAddressDto);
		newAccountDto = new AccountDto();
		newInfoPersonDto = new InfoPersonDto();
		newContactDto = new ContactDto();
		if(accountnew.getRole().equals(EnumRole.ASSOCIATION)) {
			return "/association/createAssociationForm";
		}
		return "login";
	}

}
