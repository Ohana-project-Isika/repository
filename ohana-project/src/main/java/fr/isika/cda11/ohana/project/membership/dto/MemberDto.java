package fr.isika.cda11.ohana.project.membership.dto;

import java.io.Serializable;
import java.util.List;

import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.membership.models.SubscriptionFee;

public class MemberDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8708958154827350553L;

	private Long idMember;

	private PrivatePersonDto privatePerson;

	private List<SubscriptionFeeDto> subscriptionFeeList;
	
	//constructeur
	public MemberDto( ) {}

	public Long getIdMember() {
		return idMember;
	}

	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}

	public PrivatePersonDto getPrivatePerson() {
		return privatePerson;
	}

	public void setPrivatePerson(PrivatePersonDto privatepersonDto) {
		this.privatePerson = privatepersonDto;
	}

	public List<SubscriptionFeeDto> getSubscriptionFeeList() {
		return subscriptionFeeList;
	}

	public void setSubscriptionFeeList(List<SubscriptionFeeDto> subscriptionFeeList) {
		this.subscriptionFeeList = subscriptionFeeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		MemberDto other = (MemberDto) obj;
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
		return "MemberDto [idMember=" + idMember + ", privatePerson=" + privatePerson + ", subscriptionFeeList="
				+ subscriptionFeeList + "]";
	}
	
	
	
	
}
