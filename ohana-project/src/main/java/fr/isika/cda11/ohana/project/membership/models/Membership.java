package fr.isika.cda11.ohana.project.membership.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.models.Association;

@Entity
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMbs;
	private String nameMbs;		
	private Date dateOfStart;
	private Date dateOfEnd;

	// relations
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="SUBSCRIPTIONFEE_ID", unique=true, nullable=false)
	private SubscriptionFee subscriptionFee;
	@ManyToOne
	@JoinColumn(name="MEMBERSHIPMANAGE_ID")
	private MemberShipManage memberShipManage;

	//constructeur
	public Membership() {}

	// getter et setter
	public String getNameMbs()			{return nameMbs;}
	public void setNameMbs(String nameMbs){this.nameMbs = nameMbs;	}

	public Date getDateOfStart() 				{return dateOfStart;}
	public void setDateOfStart(Date dateOfStart){this.dateOfStart = dateOfStart;	}

	public Date getDateOfEnd() {return dateOfEnd;}
	public void setDateOfEnd(Date dateOfEnd) {this.dateOfEnd = dateOfEnd;}



	public MemberShipManage getMemberShipManage() {
		return memberShipManage;
	}

	public void setMemberShipManage(MemberShipManage memberShipManage) {
		this.memberShipManage = memberShipManage;
	}

	public void setIdMbs(Long idMbs) {
		this.idMbs = idMbs;
	}

	public SubscriptionFee getSubscriptionFee() {return subscriptionFee;}
	public void setSubscriptionFee(SubscriptionFee subscriptionFee) {this.subscriptionFee = subscriptionFee;}

	public long getIdMbs() {return idMbs;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfEnd == null) ? 0 : dateOfEnd.hashCode());
		result = prime * result + ((dateOfStart == null) ? 0 : dateOfStart.hashCode());
		result = prime * result + ((idMbs == null) ? 0 : idMbs.hashCode());
		result = prime * result + ((memberShipManage == null) ? 0 : memberShipManage.hashCode());
		result = prime * result + ((nameMbs == null) ? 0 : nameMbs.hashCode());
		result = prime * result + ((subscriptionFee == null) ? 0 : subscriptionFee.hashCode());
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
		Membership other = (Membership) obj;
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
		if (idMbs == null) {
			if (other.idMbs != null)
				return false;
		} else if (!idMbs.equals(other.idMbs))
			return false;
		if (memberShipManage == null) {
			if (other.memberShipManage != null)
				return false;
		} else if (!memberShipManage.equals(other.memberShipManage))
			return false;
		if (nameMbs == null) {
			if (other.nameMbs != null)
				return false;
		} else if (!nameMbs.equals(other.nameMbs))
			return false;
		if (subscriptionFee == null) {
			if (other.subscriptionFee != null)
				return false;
		} else if (!subscriptionFee.equals(other.subscriptionFee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Membership [idMbs=" + idMbs + ", nameMbs=" + nameMbs + ", dateOfStart=" + dateOfStart + ", dateOfEnd="
				+ dateOfEnd + ", subscriptionFee=" + subscriptionFee + ", memberShipManage=" + memberShipManage + "]";
	}

	
	
}