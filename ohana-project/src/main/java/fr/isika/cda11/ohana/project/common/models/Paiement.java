package fr.isika.cda11.ohana.project.common.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Paiement {
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPayment;
	private String paymentRef;
	private Boolean validated;
	private Date paymentDate;
	
	//Relations

	@ManyToOne
	private PrivatePerson privatePerson;
	
	//Constructeur
	public Paiement() {}

	
	// Getter &Setter
	
	public String getpaymentRef() {	return paymentRef;}
	public void setpaymentRef(String paymentRef) {this.paymentRef = paymentRef;}
	
	public Boolean getValidated() {	return validated;}
	public void setValidated(Boolean validated) {this.validated = validated;}

	public Date getPaymentDate() {return paymentDate;}
	public void setPaymentDate(Date paymentDate) {	this.paymentDate = paymentDate;}

//	public List<Association> getAssociation() {	return association;}
//	public void setAssociation(List<Association> association) {this.association = association;}

	public PrivatePerson getPrivatePerson() {return privatePerson;}
	public void setPrivatePerson(PrivatePerson privatePerson) {	this.privatePerson = privatePerson;}

	public Long getIdPayment() {return idPayment;	}

	
	// Hash&equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((association == null) ? 0 : association.hashCode());
		result = prime * result + ((idPayment == null) ? 0 : idPayment.hashCode());
		result = prime * result + ((paymentRef == null) ? 0 : paymentRef.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((privatePerson == null) ? 0 : privatePerson.hashCode());
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
/*		if (association == null) {
			if (other.association != null)
				return false;
		} else if (!association.equals(other.association))
			return false;  */
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
		if (privatePerson == null) {
			if (other.privatePerson != null)
				return false;
		} else if (!privatePerson.equals(other.privatePerson))
			return false;
		if (validated == null) {
			if (other.validated != null)
				return false;
		} else if (!validated.equals(other.validated))
			return false;
		return true;
	}

	
	// String toString
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paiement [idPayment=");
		builder.append(idPayment);
		builder.append(", validated=");
		builder.append(validated);
		builder.append(", paymentDate=");
		builder.append(paymentDate);
		builder.append(", paymentRef=");
		builder.append(paymentRef);
		builder.append(", association=");
//		builder.append(association);
		builder.append(", privatePerson=");
		builder.append(privatePerson);
		builder.append("]");
		return builder.toString();
	}
	
}
