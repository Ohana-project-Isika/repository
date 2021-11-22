package fr.isika.cda11.ohana.project.membership.dto;

import java.io.Serializable;
import java.util.Date;
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
	private Date dateOfStart;
	private Date dateOfEnd;
	private MembershipDto membershipDto;

	
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

	public Date getDateOfStart() 				{return dateOfStart;}
	public void setDateOfStart(Date dateOfStart){this.dateOfStart = dateOfStart;	}

	public Date getDateOfEnd() {return dateOfEnd;}
	public void setDateOfEnd(Date dateOfEnd) {this.dateOfEnd = dateOfEnd;}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MembershipDto getMembershipDto() {
		return membershipDto;
	}

	public void setMembershipDto(MembershipDto membershipDto) {
		this.membershipDto = membershipDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfEnd == null) ? 0 : dateOfEnd.hashCode());
		result = prime * result + ((dateOfStart == null) ? 0 : dateOfStart.hashCode());
		result = prime * result + ((idMember == null) ? 0 : idMember.hashCode());
		result = prime * result + ((membershipDto == null) ? 0 : membershipDto.hashCode());
		result = prime * result + ((privatePerson == null) ? 0 : privatePerson.hashCode());
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
		if (idMember == null) {
			if (other.idMember != null)
				return false;
		} else if (!idMember.equals(other.idMember))
			return false;
		if (membershipDto == null) {
			if (other.membershipDto != null)
				return false;
		} else if (!membershipDto.equals(other.membershipDto))
			return false;
		if (privatePerson == null) {
			if (other.privatePerson != null)
				return false;
		} else if (!privatePerson.equals(other.privatePerson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberDto [idMember=" + idMember + ", privatePerson=" + privatePerson + ", dateOfStart=" + dateOfStart
				+ ", dateOfEnd=" + dateOfEnd + ", membershipDto=" + membershipDto + "]";
	}


	
	
	
}
