package fr.isika.cda11.ohana.project.membership.models;
import java.util.List;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import fr.isika.cda11.ohana.project.common.models.InfoPerson;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;

@Entity
public class Member {			// ou extends PrivatePerson  -> pas d'@Id  
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMember;
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="PRIVATEPERSON_ID", unique=true, nullable=false)
	private PrivatePerson privatePerson;

	@ManyToMany
	private List<SubscriptionFee> subscriptionFeeList;
	
	//constructeur
	public Member( ) {}

	// getter et setter
	public List<SubscriptionFee> getSubscriptionFeeList() {return subscriptionFeeList;}
	public void setSubscriptionFeeList(List<SubscriptionFee> subscriptionFeeList) {	this.subscriptionFeeList = subscriptionFeeList;}

	public Long getIdMember() {return idMember;}

	//hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMember == null) ? 0 : idMember.hashCode());
		result = prime * result + ((subscriptionFeeList == null) ? 0 : subscriptionFeeList.hashCode());
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
		Member other = (Member) obj;
		if (idMember == null) {
			if (other.idMember != null)
				return false;
		} else if (!idMember.equals(other.idMember))
			return false;
		if (subscriptionFeeList == null) {
			if (other.subscriptionFeeList != null)
				return false;
		} else if (!subscriptionFeeList.equals(other.subscriptionFeeList))
			return false;
		return true;
	}

	// String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [idMember=");
		builder.append(idMember);
		builder.append(", subscriptionFeeList=");
		builder.append(subscriptionFeeList);
		builder.append("]");
		return builder.toString();
	}

}
