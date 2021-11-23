package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ServicesDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3822590383910797050L;
	//ATTRIBUTS
	private Long idServices;
	private String typeOfSub;
	private BigDecimal priceOfSub;

	
	//GETTER AND SETTER
	public Long getIdServices() {return idServices;}
	public void setIdServices(Long idServices) {this.idServices = idServices;}
	public String getTypeOfSub() {return typeOfSub;}
	public void setTypeOfSub(String typeOfSub) {this.typeOfSub = typeOfSub;}
	public BigDecimal getPriceOfSub() {return priceOfSub;}
	public void setPriceOfSub(BigDecimal priceOfSub) {this.priceOfSub = priceOfSub;}
	
	//CONSTRUCTOR

	public ServicesDto() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ServicesDto other = (ServicesDto) obj;
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
	@Override
	public String toString() {
		return "ServicesDto [idServices=" + idServices + ", typeOfSub=" + typeOfSub + ", priceOfSub=" + priceOfSub
				+ "]";
	}
	
	
}
