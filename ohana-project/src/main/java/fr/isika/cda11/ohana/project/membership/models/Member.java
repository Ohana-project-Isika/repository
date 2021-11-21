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

import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.models.InfoPerson;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;

@Entity
public class Member {			// ou extends PrivatePerson  -> pas d'@Id  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMember;
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="PRIVATEPERSON_ID", unique=true, nullable=false)
	private PrivatePerson privatePerson;

	@ManyToMany
	private List<SubscriptionFee> subscriptionFeeList;
	
	//constructeur
	public Member( ) {}

	public Long getIdMember() {
		return idMember;
	}

	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}

	public PrivatePerson getPrivatePerson() {
		return privatePerson;
	}

	public void setPrivatePerson(PrivatePerson privatePerson) {
		this.privatePerson = privatePerson;
	}

	public List<SubscriptionFee> getSubscriptionFeeList() {
		return subscriptionFeeList;
	}

	public void setSubscriptionFeeList(List<SubscriptionFee> subscriptionFeeList) {
		this.subscriptionFeeList = subscriptionFeeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMember == null) ? 0 : idMember.hashCode());
		result = prime * result + ((privatePerson == null) ? 0 : privatePerson.hashCode());
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
		if (privatePerson == null) {
			if (other.privatePerson != null)
				return false;
		} else if (!privatePerson.equals(other.privatePerson))
			return false;
		if (subscriptionFeeList == null) {
			if (other.subscriptionFeeList != null)
				return false;
		} else if (!subscriptionFeeList.equals(other.subscriptionFeeList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", privatePerson=" + privatePerson + ", subscriptionFeeList="
				+ subscriptionFeeList + "]";
	}

	

}
