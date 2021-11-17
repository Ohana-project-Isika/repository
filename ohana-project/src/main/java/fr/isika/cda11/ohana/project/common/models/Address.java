package fr.isika.cda11.ohana.project.common.models;
import lombok.*;

import javax.persistence.*;


//TODO : garder ou supprimer les lignes correspondant à l'attribut suffix

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Long idAddress;
	private Integer numRue;	
	private String rue;
	//private String rue2; 			// complément d'adresse : lieu-dit, numero de batiment, n° appartement etc...
	private String codePostal;
	private String ville;
	private String pays;			//facultatif ou automatique en France si code postal (5 chiffres) ou ville correspondent
//	private Enum<?> suffix; 			// à quoi cela correspond-il? TODO

	// pas de Relation 


	//constructeur
	public Address( ) {}
	

	//getter et setter
	public Integer getNumRue() 			{return numRue;}
	public void setNumRue(Integer numRue) 	{this.numRue = numRue;}

	public String getRue() 					{return rue;}
	public void setRue(String rue) 			{this.rue = rue;}

	//public String getRue2() 				{return rue2;}
	//public void setRue2(String rue2) 		{this.rue2 = rue2;}

	public String getCodePostal() 			{return codePostal;}
	public void setCodePostal(String codePostal) {this.codePostal = codePostal;}

	public String getVille() 				{return ville;}
	public void setVille(String ville) 		{this.ville = ville;}

	public String getPays() 				{return pays;}
	public void setPays(String pays)		{this.pays = pays;}

//	public Enum getSuffix() 				{return suffix;}
//	public void setSuffix(Enum suffix) 		{this.suffix = suffix;}

	public long getIdAddress() 				{return idAddress;}
	public void setIdAddress(Long idAddress) {this.idAddress = idAddress;}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((idAddress == null) ? 0 : idAddress.hashCode());
		result = prime * result + ((numRue == null) ? 0 : numRue.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
//		result = prime * result + ((rue2 == null) ? 0 : rue2.hashCode());
//		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
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
//		if (rue2 == null) {
//			if (other.rue2 != null)
//				return false;
//		} else if (!rue2.equals(other.rue2))
//			return false;
/*		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;*/
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [idAddress=");
		builder.append(idAddress);
		builder.append(", numRue=");
		builder.append(numRue);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", rue2=");
//		builder.append(rue2);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", pays=");
		builder.append(pays);
		builder.append(", suffix=");
//		builder.append(suffix);
		builder.append(", personInfo=");
		builder.append("]");
		return builder.toString();
	}
	

	@Enumerated(value = EnumType.STRING)
	private Suffix suffix;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_complement")
	private String streetComplement;

	private String postCode;
	private String city;
}
