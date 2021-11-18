package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Services;
import fr.isika.cda11.ohana.project.enumclass.ValidateStatusAsso;

public class AssociationDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030236931266644976L;
	
	//ATTIBUTS
	private Long idAssos;
	private String nameAssos;
	private ValidateStatusAsso validateStatusAsso;
	private String logoAsso;
	private String justifAsso;
	private String numSiret;
	
	//RELATIONS
	private AddressDto addressAsso;
	private ServicesDto services;
	private AccountDto account;

	// constructeur
	public AssociationDto() {}

	public Long getIdAssos() {
		return idAssos;
	}

	public void setIdAssos(Long idAssos) {
		this.idAssos = idAssos;
	}

	public String getNameAssos() {
		return nameAssos;
	}

	public void setNameAssos(String nameAssos) {
		this.nameAssos = nameAssos;
	}

	public ValidateStatusAsso getValidateStatusAsso() {
		return validateStatusAsso;
	}

	public void setValidateStatusAsso(ValidateStatusAsso validateStatusAsso) {
		this.validateStatusAsso = validateStatusAsso;
	}

	public String getLogoAsso() {
		return logoAsso;
	}

	public void setLogoAsso(String logoAsso) {
		this.logoAsso = logoAsso;
	}

	public String getJustifAsso() {
		return justifAsso;
	}

	public void setJustifAsso(String justifAsso) {
		this.justifAsso = justifAsso;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public AddressDto getAddressAsso() {
		return addressAsso;
	}

	public void setAddressAsso(AddressDto addressAsso) {
		this.addressAsso = addressAsso;
	}

	public ServicesDto getServices() {
		return services;
	}

	public void setServices(ServicesDto services) {
		this.services = services;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
