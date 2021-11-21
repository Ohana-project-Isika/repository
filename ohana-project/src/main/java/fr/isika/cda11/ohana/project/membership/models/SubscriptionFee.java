package fr.isika.cda11.ohana.project.membership.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SubscriptionFee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSubFee;
	private Integer feeAmount;
	private Date dateOfStart;
	private Date dateOfEnd;

	// Relations
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="MEMBERSHIP_ID", unique=true, nullable=false)
	private Membership membership;

	// constructeur vide
	public SubscriptionFee() {
	}

	public Long getIdSubFee() {
		return idSubFee;
	}

	public void setIdSubFee(Long idSubFee) {
		this.idSubFee = idSubFee;
	}

	public Integer getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(Integer feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public Date getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(Date dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfEnd == null) ? 0 : dateOfEnd.hashCode());
		result = prime * result + ((dateOfStart == null) ? 0 : dateOfStart.hashCode());
		result = prime * result + ((feeAmount == null) ? 0 : feeAmount.hashCode());
		result = prime * result + ((idSubFee == null) ? 0 : idSubFee.hashCode());
		result = prime * result + ((membership == null) ? 0 : membership.hashCode());
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
		SubscriptionFee other = (SubscriptionFee) obj;
		if (dateOfEnd == null) {
			if (other.dateOfEnd != null)
				return false;
		} else if (!dateOfEnd.equals(other.dateOfEnd))
			return false;
		if (dateOfStart == null) {
			if (other.dateOfStart != null)
				return false;
		} else if (!dateOfStart.equals(other.dateOfStart))
			return false;
		if (feeAmount == null) {
			if (other.feeAmount != null)
				return false;
		} else if (!feeAmount.equals(other.feeAmount))
			return false;
		if (idSubFee == null) {
			if (other.idSubFee != null)
				return false;
		} else if (!idSubFee.equals(other.idSubFee))
			return false;
		if (membership == null) {
			if (other.membership != null)
				return false;
		} else if (!membership.equals(other.membership))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubscriptionFee [idSubFee=" + idSubFee + ", feeAmount=" + feeAmount + ", dateOfStart=" + dateOfStart
				+ ", dateOfEnd=" + dateOfEnd + ", membership=" + membership + "]";
	}


}
