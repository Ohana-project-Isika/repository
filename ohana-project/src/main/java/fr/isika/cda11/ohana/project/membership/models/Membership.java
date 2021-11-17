package fr.isika.cda11.ohana.project.membership.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.models.Association;

@Entity
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMbs;


	private String nameMbs;				// Mbs pour membership
	private Date dateOfStart;
	private Date dateOfEnd;

	// relations
	@OneToOne
	private SubscriptionFee subscriptionFee;
	@OneToOne
	private Association association;

	//constructeur
	public Membership() {}

	// getter et setter
	public String getNameMbs()			{return nameMbs;}
	public void setNameMbs(String nameMbs){this.nameMbs = nameMbs;	}

	public Date getDateOfStart() 				{return dateOfStart;}
	public void setDateOfStart(Date dateOfStart){this.dateOfStart = dateOfStart;	}

	public Date getDateOfEnd() {return dateOfEnd;}
	public void setDateOfEnd(Date dateOfEnd) {this.dateOfEnd = dateOfEnd;}

	public Association getAssociation() {return association;}
	public void setAssociation(Association association) {this.association = association;}

	public SubscriptionFee getSubscriptionFee() {return subscriptionFee;}
	public void setSubscriptionFee(SubscriptionFee subscriptionFee) {this.subscriptionFee = subscriptionFee;}

	public long getIdMbs() {return idMbs;}

	//Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((association == null) ? 0 : association.hashCode());
		result = prime * result + ((dateOfEnd == null) ? 0 : dateOfEnd.hashCode());
		result = prime * result + ((dateOfStart == null) ? 0 : dateOfStart.hashCode());
		result = prime * result + ((idMbs == null) ? 0 : idMbs.hashCode());
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
		if (association == null) {
			if (other.association != null)
				return false;
		} else if (!association.equals(other.association))
			return false;
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

	//String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Membership [idMbs=");
		builder.append(idMbs);
		builder.append(", nameMbs=");
		builder.append(nameMbs);
		builder.append(", dateOfStart=");
		builder.append(dateOfStart);
		builder.append(", dateOfEnd=");
		builder.append(dateOfEnd);
		builder.append(", subscriptionFee=");
		builder.append(subscriptionFee);
		builder.append(", association=");
		builder.append(association);
		builder.append("]");
		return builder.toString();
	}
	
}