package fr.isika.cda11.ohana.project.common.models;
import lombok.*;

import javax.persistence.*;


//TODO : garder ou supprimer les lignes correspondant à l'attribut suffix

@Entity
public class Address {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddress;
	private Integer numRue;	
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;

	//NO RELATIONS
	
	//CONSTRUCTOR
	public Address( ) {}

	//GETTER AND SETTER
	public Long getIdAddress() {return idAddress;}
	public void setIdAddress(Long idAddress) {this.idAddress = idAddress;}
	public Integer getNumRue() {return numRue;}
	public void setNumRue(Integer numRue) {this.numRue = numRue;}
	public String getRue() {return rue;}
	public void setRue(String rue) {this.rue = rue;}
	public String getCodePostal() {return codePostal;}
	public void setCodePostal(String codePostal) {this.codePostal = codePostal;}
	public String getVille() {return ville;}
	public void setVille(String ville) {this.ville = ville;}
	public String getPays() {return pays;}
	public void setPays(String pays) {this.pays = pays;}

	//HASCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((idAddress == null) ? 0 : idAddress.hashCode());
		result = prime * result + ((numRue == null) ? 0 : numRue.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Address other = (Address) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (idAddress == null) {
			if (other.idAddress != null)
				return false;
		} else if (!idAddress.equals(other.idAddress))
			return false;
		if (numRue == null) {
			if (other.numRue != null)
				return false;
		} else if (!numRue.equals(other.numRue))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	
	// METHOD TO STRING

	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", numRue=" + numRue + ", rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + "]";
	}

	

}
