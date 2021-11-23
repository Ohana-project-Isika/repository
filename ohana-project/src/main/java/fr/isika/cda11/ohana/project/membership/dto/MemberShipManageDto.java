package fr.isika.cda11.ohana.project.membership.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import fr.isika.cda11.ohana.project.common.dto.AssociationDto;


public class MemberShipManageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4959234758580787131L;

	private Long id;

	private AssociationDto association = new AssociationDto();
	
	private List<MembershipDto> memberships = new ArrayList<MembershipDto>();
	
	public MemberShipManageDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssociationDto getAssociation() {
		return association;
	}

	public void setAssociation(AssociationDto association) {
		this.association = association;
	}

	public List<MembershipDto> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<MembershipDto> memberships) {
		this.memberships = memberships;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		MemberShipManageDto other = (MemberShipManageDto) obj;
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
		return "MemberShipManageDto [id=" + id + ", association=" + association + ", memberships=" + memberships + "]";
	}
	
	
}
