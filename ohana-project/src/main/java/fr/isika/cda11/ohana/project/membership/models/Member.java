package fr.isika.cda11.ohana.project.membership.models;
import java.util.Date;
import java.util.List;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.models.InfoPerson;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;

@Entity
@NamedQueries({
	@NamedQuery(name = "member.findAll", query = "SELECT c FROM Member c")})
public class Member {			// ou extends PrivatePerson  -> pas d'@Id  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMember;
	@ManyToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="PRIVATEPERSON_ID", nullable=false)
	private PrivatePerson privatePerson;
	private Date dateOfStart;
	private Date dateOfEnd;
	@ManyToOne
	@JoinColumn(name="MEMBERSHIP_ID")
	private Membership membership;

	
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

	
	public Date getDateOfStart() 				{return dateOfStart;}
	public void setDateOfStart(Date dateOfStart){this.dateOfStart = dateOfStart;	}

	public Date getDateOfEnd() {return dateOfEnd;}
	public void setDateOfEnd(Date dateOfEnd) {this.dateOfEnd = dateOfEnd;}

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
		result = prime * result + ((idMember == null) ? 0 : idMember.hashCode());
		result = prime * result + ((membership == null) ? 0 : membership.hashCode());
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
		Member other = (Member) obj;
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
		if (membership == null) {
			if (other.membership != null)
				return false;
		} else if (!membership.equals(other.membership))
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
		return "Member [idMember=" + idMember + ", privatePerson=" + privatePerson + ", dateOfStart=" + dateOfStart
				+ ", dateOfEnd=" + dateOfEnd + ", membership=" + membership + "]";
	}



	

	

}
