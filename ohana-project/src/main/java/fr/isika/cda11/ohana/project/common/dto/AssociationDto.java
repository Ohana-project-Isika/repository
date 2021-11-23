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
	private ValidateStatusAsso validateStatusAsso = ValidateStatusAsso.INPROCESS;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((addressAsso == null) ? 0 : addressAsso.hashCode());
		result = prime * result + ((idAssos == null) ? 0 : idAssos.hashCode());
		result = prime * result + ((justifAsso == null) ? 0 : justifAsso.hashCode());
		result = prime * result + ((logoAsso == null) ? 0 : logoAsso.hashCode());
		result = prime * result + ((nameAssos == null) ? 0 : nameAssos.hashCode());
		result = prime * result + ((numSiret == null) ? 0 : numSiret.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((validateStatusAsso == null) ? 0 : validateStatusAsso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociationDto other = (AssociationDto) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (addressAsso == null) {
			if (other.addressAsso != null)
				return false;
		} else if (!addressAsso.equals(other.addressAsso))
			return false;
		if (idAssos == null) {
			if (other.idAssos != null)
				return false;
		} else if (!idAssos.equals(other.idAssos))
			return false;
		if (justifAsso == null) {
			if (other.justifAsso != null)
				return false;
		} else if (!justifAsso.equals(other.justifAsso))
			return false;
		if (logoAsso == null) {
			if (other.logoAsso != null)
				return false;
		} else if (!logoAsso.equals(other.logoAsso))
			return false;
		if (nameAssos == null) {
			if (other.nameAssos != null)
				return false;
		} else if (!nameAssos.equals(other.nameAssos))
			return false;
		if (numSiret == null) {
			if (other.numSiret != null)
				return false;
		} else if (!numSiret.equals(other.numSiret))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (validateStatusAsso != other.validateStatusAsso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssociationDto [idAssos=" + idAssos + ", nameAssos=" + nameAssos + ", validateStatusAsso="
				+ validateStatusAsso + ", logoAsso=" + logoAsso + ", justifAsso=" + justifAsso + ", numSiret="
				+ numSiret + ", addressAsso=" + addressAsso + ", services=" + services + ", account=" + account + "]";
	}
	
	
	
	
}
