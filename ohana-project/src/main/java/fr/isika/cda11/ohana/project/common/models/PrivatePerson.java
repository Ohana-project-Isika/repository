package fr.isika.cda11.ohana.project.common.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PrivatePerson {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPrivatePerson;
	private Byte photoProfil;

	//Relations 
	@OneToMany				
	private List<Paiement> paiement;
	@OneToOne
	private Role role;
	
	// Getter and setter
	public Byte getPhotoProfil() {return photoProfil;}
	public void setPhotoProfil(Byte photoProfil) {this.photoProfil = photoProfil;}
	
	public List<Paiement> getPaiement() {return paiement;}
	public void setPaiement(List<Paiement> paiement) {this.paiement = paiement;}
	
	public Role getRole() {	return role;}
	public void setRole(Role role) {this.role = role;	}
	
	public Long getIdPrivatePerson() {return idPrivatePerson;}
	
	
	//hash & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPrivatePerson == null) ? 0 : idPrivatePerson.hashCode());
		result = prime * result + ((paiement == null) ? 0 : paiement.hashCode());
		result = prime * result + ((photoProfil == null) ? 0 : photoProfil.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		PrivatePerson other = (PrivatePerson) obj;
		if (idPrivatePerson == null) {
			if (other.idPrivatePerson != null)
				return false;
		} else if (!idPrivatePerson.equals(other.idPrivatePerson))
			return false;
		if (paiement == null) {
			if (other.paiement != null)
				return false;
		} else if (!paiement.equals(other.paiement))
			return false;
		if (photoProfil == null) {
			if (other.photoProfil != null)
				return false;
		} else if (!photoProfil.equals(other.photoProfil))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	//String toString
	@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PrivatePerson [idPrivatePerson=");
			builder.append(idPrivatePerson);
			builder.append(", photoProfil=");
			builder.append(photoProfil);
			builder.append(", paiement=");
			builder.append(paiement);
			builder.append(", role=");
			builder.append(role);
			builder.append("]");
			return builder.toString();
		}

	// corps de la méthode de uml
	public void manageProfil() {
		
	}
}
