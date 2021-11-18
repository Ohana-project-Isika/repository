package fr.isika.cda11.ohana.project.common.models;

import fr.isika.cda11.ohana.project.event.models.Ticketing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Association {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAssos;
	private String nameAssos;
	private ValidateStatusAsso validateStatusAsso;
	private String logoAsso;
	private String justifAsso;
	private String numSiret;
	@OneToOne
	private Address addressAsso;
	@OneToOne
	private Services services;
	@OneToOne
	private Role role;
	@OneToOne
	private Ticketing ticketing;

	// constructeur
	public Association() {}

	public Long getIdAssos() {
		return idAssos;
	}

	public Ticketing getTicketing() {
		return ticketing;
	}

	public void setTicketing(Ticketing ticketing) {
		this.ticketing = ticketing;
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

	public Address getAddressAsso() {
		return addressAsso;
	}

	public void setAddressAsso(Address addressAsso) {
		this.addressAsso = addressAsso;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressAsso == null) ? 0 : addressAsso.hashCode());
		result = prime * result + ((idAssos == null) ? 0 : idAssos.hashCode());
		result = prime * result + ((justifAsso == null) ? 0 : justifAsso.hashCode());
		result = prime * result + ((logoAsso == null) ? 0 : logoAsso.hashCode());
		result = prime * result + ((nameAssos == null) ? 0 : nameAssos.hashCode());
		result = prime * result + ((numSiret == null) ? 0 : numSiret.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Association other = (Association) obj;
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
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
		return "Association [idAssos=" + idAssos + ", nameAssos=" + nameAssos + ", validateStatusAsso="
				+ validateStatusAsso + ", logoAsso=" + logoAsso + ", justifAsso=" + justifAsso + ", numSiret="
				+ numSiret + ", addressAsso=" + addressAsso + ", services=" + services + ", role=" + role + "]";
	}

	
	

}
