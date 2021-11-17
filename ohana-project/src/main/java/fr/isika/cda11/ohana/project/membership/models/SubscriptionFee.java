package fr.isika.cda11.ohana.project.membership.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@OneToOne
	private Membership membership;
	
	@ManyToOne
	private Member member;

	// constructeur vide
	public SubscriptionFee() {
	}

	// getter et setter
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Long getIdSubFee() {
		return idSubFee;
	}

	// hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfEnd == null) ? 0 : dateOfEnd.hashCode());
		result = prime * result + ((dateOfStart == null) ? 0 : dateOfStart.hashCode());
		result = prime * result + ((feeAmount == null) ? 0 : feeAmount.hashCode());
		result = prime * result + ((idSubFee == null) ? 0 : idSubFee.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
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
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (membership == null) {
			if (other.membership != null)
				return false;
		} else if (!membership.equals(other.membership))
			return false;
		return true;
	}

	// String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubscriptionFee [idSubFee=");
		builder.append(idSubFee);
		builder.append(", feeAmount=");
		builder.append(feeAmount);
		builder.append(", dateOfStart=");
		builder.append(dateOfStart);
		builder.append(", dateOfEnd=");
		builder.append(dateOfEnd);
		builder.append(", membership=");
		builder.append(membership);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

}
