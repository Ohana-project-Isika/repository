package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idServices;

	private String typeOfSub;
	private Integer priceOfSub;

	// bidirectionnel
	@OneToOne
	private Association association;

	// getter and setter
	public String getTypeOfSub() {
		return typeOfSub;
	}

	public void setTypeOfSub(String typeOfSub) {
		this.typeOfSub = typeOfSub;
	}

	public Integer getPriceOfSub() {
		return priceOfSub;
	}

	public void setPriceOfSub(Integer priceOfSub) {
		this.priceOfSub = priceOfSub;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public Long getIdServices() {
		return idServices;
	}

	// HAsh ans code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((association == null) ? 0 : association.hashCode());
		result = prime * result + ((idServices == null) ? 0 : idServices.hashCode());
		result = prime * result + ((priceOfSub == null) ? 0 : priceOfSub.hashCode());
		result = prime * result + ((typeOfSub == null) ? 0 : typeOfSub.hashCode());
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
		Services other = (Services) obj;
		if (association == null) {
			if (other.association != null)
				return false;
		} else if (!association.equals(other.association))
			return false;
		if (idServices == null) {
			if (other.idServices != null)
				return false;
		} else if (!idServices.equals(other.idServices))
			return false;
		if (priceOfSub == null) {
			if (other.priceOfSub != null)
				return false;
		} else if (!priceOfSub.equals(other.priceOfSub))
			return false;
		if (typeOfSub == null) {
			if (other.typeOfSub != null)
				return false;
		} else if (!typeOfSub.equals(other.typeOfSub))
			return false;
		return true;
	}

	// String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Services [idServices=");
		builder.append(idServices);
		builder.append(", typeOfSub=");
		builder.append(typeOfSub);
		builder.append(", priceOfSub=");
		builder.append(priceOfSub);
		builder.append(", association=");
		builder.append(association);
		builder.append("]");
		return builder.toString();
	}

	// corps de la méthode de uml
	public void subscribe() {
	}
}
