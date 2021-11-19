package fr.isika.cda11.ohana.project.membership.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.models.Association;

@Entity
public class MemberShipManage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name="ASSOCIATION_ID", unique=true, nullable=false)
	private Association association = new Association();
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="MEMBERSHIPMANAGE_ID")
	private List<Membership> memberships = new ArrayList<Membership>();
	
	public MemberShipManage() {
		
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public List<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((association == null) ? 0 : association.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberships == null) ? 0 : memberships.hashCode());
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
		MemberShipManage other = (MemberShipManage) obj;
		if (association == null) {
			if (other.association != null)
				return false;
		} else if (!association.equals(other.association))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memberships == null) {
			if (other.memberships != null)
				return false;
		} else if (!memberships.equals(other.memberships))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberShipManage [id=" + id + ", association=" + association + ", memberships=" + memberships + "]";
	}
	

}
