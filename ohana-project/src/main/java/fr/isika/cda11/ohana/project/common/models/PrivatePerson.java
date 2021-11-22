package fr.isika.cda11.ohana.project.common.models;

import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.models.Ticket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PrivatePerson {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrivatePerson;
	private String photoProfil;

	//RELATIONS 
	@OneToMany
	@JoinColumn(name="PRIVATEPERSON_ID")
	private List<Paiement> paiement;
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="ACCOUNT_ID", nullable=false)
	private Account account;

	@OneToMany(mappedBy = "privatePerson")
	private List<Ticket> tickets  = new ArrayList<>();

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	//GETTER AND SETTER
	public Long getIdPrivatePerson() {return idPrivatePerson;}
	public void setIdPrivatePerson(Long idPrivatePerson) {this.idPrivatePerson = idPrivatePerson;}
	public String getPhotoProfil() {return photoProfil;}
	public void setPhotoProfil(String photoProfil) {this.photoProfil = photoProfil;}
	public List<Paiement> getPaiement() {return paiement;}
	public void setPaiement(List<Paiement> paiement) {this.paiement = paiement;}
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}
	
	
	//CONSTRUCTOR
	public PrivatePerson() {}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((idPrivatePerson == null) ? 0 : idPrivatePerson.hashCode());
		result = prime * result + ((paiement == null) ? 0 : paiement.hashCode());
		result = prime * result + ((photoProfil == null) ? 0 : photoProfil.hashCode());
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
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
		return true;
	}
	
	//METHOD TOSTRING
	@Override
	public String toString() {
		return "PrivatePerson [idPrivatePerson=" + idPrivatePerson + ", photoProfil=" + photoProfil + ", paiement="
				+ paiement + ", account=" + account + "]";
	}
	
}
