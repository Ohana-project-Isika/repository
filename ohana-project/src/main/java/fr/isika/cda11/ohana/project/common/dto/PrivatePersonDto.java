package fr.isika.cda11.ohana.project.common.dto;

import fr.isika.cda11.ohana.project.common.models.MeansOfPayment;
import fr.isika.cda11.ohana.project.event.models.Ticket;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrivatePersonDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 728672485924722258L;

	
	//ATTRIBUTS
	private Long idPrivatePerson;
	private String photoProfil;

	//RELATIONS 
	private List<PaiementDto> paiement;
	private AccountDto account;
	private List<Ticket> tickets = new ArrayList<>();
	private List<MeansOfPayment> meansOfPayments  = new ArrayList<>();

	//CONSTRUCTOR
	public PrivatePersonDto() {}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public void addMeans(MeansOfPayment meansOfPayment) {
		meansOfPayments.add(meansOfPayment);
	}

	public Long getIdPrivatePerson() {
		return idPrivatePerson;
	}

	public void setIdPrivatePerson(Long idPrivatePerson) {
		this.idPrivatePerson = idPrivatePerson;
	}

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public List<PaiementDto> getPaiement() {
		return paiement;
	}

	public void setPaiement(List<PaiementDto> paiement) {
		this.paiement = paiement;
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
		PrivatePersonDto other = (PrivatePersonDto) obj;
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

	@Override
	public String toString() {
		return "PrivatePersonDto [idPrivatePerson=" + idPrivatePerson + ", photoProfil=" + photoProfil + ", paiement="
				+ paiement + ", account=" + account + "]";
	}
	
	
}
