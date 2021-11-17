package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Association {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAssos;
	private String nameAssos;
	// private ENUM validateStatusAsso;
	// private ENUM subscriptionAsso;
	private Byte logoAsso;
	private Byte justifAsso;
	private String numSiret;
	@OneToOne
	private Address addressAsso;
	@OneToOne
	private Services services;
	@OneToOne
	private Role role;

	// constructeur
	public Association() {}

	// getter and setter 
	
	public String getNameAssos() {return nameAssos;}
	public void setNameAssos(String nameAssos) {this.nameAssos = nameAssos;}

	public Byte getLogoAsso() {return logoAsso;}
	public void setLogoAsso(Byte logoAsso) {this.logoAsso = logoAsso;}

	public Byte getJustifAsso() {return justifAsso;}
	public void setJustifAsso(Byte justifAsso) {this.justifAsso = justifAsso;}

	public String getNumSiret() {return numSiret;}
	public void setNumSiret(String numSiret) {this.numSiret = numSiret;}

	public Address getAddressAsso() {return addressAsso;}
	public void setAddressAsso(Address addressAsso) {this.addressAsso = addressAsso;}

	public Services getServices() {	return services;}
	public void setServices(Services services) {this.services = services;}

	public Role getRole() {	return role;}
	public void setRole(Role role) {this.role = role;}

	public Long getIdAssos() {return idAssos;}
	

	public void setIdAssos(Long idAssos) {this.idAssos = idAssos;}

	// Hash&equals
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
		return true;
	}

	// String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Association [idAssos=");
		builder.append(idAssos);
		builder.append(", nameAssos=");
		builder.append(nameAssos);
		builder.append(", logoAsso=");
		builder.append(logoAsso);
		builder.append(", justifAsso=");
		builder.append(justifAsso);
		builder.append(", numSiret=");
		builder.append(numSiret);
		builder.append(", addressAsso=");
		builder.append(addressAsso);
		builder.append(", services=");
		builder.append(services);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
