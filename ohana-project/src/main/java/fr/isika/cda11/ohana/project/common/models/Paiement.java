package fr.isika.cda11.ohana.project.common.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Paiement {
	
	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPayment;
	private String paymentRef;
	private Boolean validated;
	@Temporal(TemporalType.DATE)  
	private Date paymentDate;
	
	//RELATION

	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	//CONSTRUCTOR
	public Paiement() {}

	public Long getIdPayment() {return idPayment;}
	public void setIdPayment(Long idPayment) {this.idPayment = idPayment;}
	public String getPaymentRef() {return paymentRef;}
	public void setPaymentRef(String paymentRef) {this.paymentRef = paymentRef;}
	public Boolean getValidated() {return validated;}
	public void setValidated(Boolean validated) {this.validated = validated;}
	public Date getPaymentDate() {return paymentDate;}
	public void setPaymentDate(Date paymentDate) {this.paymentDate = paymentDate;}
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((idPayment == null) ? 0 : idPayment.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((paymentRef == null) ? 0 : paymentRef.hashCode());
		result = prime * result + ((validated == null) ? 0 : validated.hashCode());
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
		Paiement other = (Paiement) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (idPayment == null) {
			if (other.idPayment != null)
				return false;
		} else if (!idPayment.equals(other.idPayment))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentRef == null) {
			if (other.paymentRef != null)
				return false;
		} else if (!paymentRef.equals(other.paymentRef))
			return false;
		if (validated == null) {
			if (other.validated != null)
				return false;
		} else if (!validated.equals(other.validated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paiement [idPayment=" + idPayment + ", paymentRef=" + paymentRef + ", validated=" + validated
				+ ", paymentDate=" + paymentDate + ", account=" + account + "]";
	}

	

}
