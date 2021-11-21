package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.enumclass.ValidateStatusAsso;

@Entity
@NamedQueries({
	@NamedQuery(name = "association.findAll", query = "SELECT c FROM Association c")})
public class Association {

	//ATTIBUTS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAssos;
	@Column(nullable=false)
	private String nameAssos;
	@Enumerated(EnumType.STRING)
	private ValidateStatusAsso validateStatusAsso = ValidateStatusAsso.INPROCESS;
	private String logoAsso;
	private String justifAsso;
	@Column(nullable=false)
	private String numSiret;
	
	//RELATIONS
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address addressAsso;
	@ManyToOne
	@JoinColumn(name="SERVICES_ID")
	private Services services;
	@OneToOne //(cascade = CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;

	// constructeur
	public Association() {}

	//GETTER AND SETTER
	public Long getIdAssos() {return idAssos;}
	public void setIdAssos(Long idAssos) {this.idAssos = idAssos;}
	public String getNameAssos() {return nameAssos;}
	public void setNameAssos(String nameAssos) {this.nameAssos = nameAssos;}
	public ValidateStatusAsso getValidateStatusAsso() {return validateStatusAsso;}
	public void setValidateStatusAsso(ValidateStatusAsso validateStatusAsso) {this.validateStatusAsso = validateStatusAsso;}
	public String getLogoAsso() {return logoAsso;}
	public void setLogoAsso(String logoAsso) {this.logoAsso = logoAsso;}
	public String getJustifAsso() {return justifAsso;}
	public void setJustifAsso(String justifAsso) {this.justifAsso = justifAsso;}
	public String getNumSiret() {return numSiret;}
	public void setNumSiret(String numSiret) {this.numSiret = numSiret;}
	public Address getAddressAsso() {return addressAsso;}
	public void setAddressAsso(Address addressAsso) {this.addressAsso = addressAsso;}
	public Services getServices() {return services;}
	public void setServices(Services services) {this.services = services;}
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

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

	//HASCODE AND EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Association other = (Association) obj;
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

	//METHOD TO STRING
	@Override
	public String toString() {
		return "Association [idAssos=" + idAssos + ", nameAssos=" + nameAssos + ", validateStatusAsso="
				+ validateStatusAsso + ", logoAsso=" + logoAsso + ", justifAsso=" + justifAsso + ", numSiret="
				+ numSiret + ", addressAsso=" + addressAsso + ", services=" + services + ", account=" + account + "]";
	}


	


}
