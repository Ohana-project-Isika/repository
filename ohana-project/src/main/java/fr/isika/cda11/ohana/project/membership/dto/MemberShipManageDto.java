package fr.isika.cda11.ohana.project.membership.dto;

import java.util.ArrayList;
import java.util.List;


import fr.isika.cda11.ohana.project.common.dto.AssociationDto;


public class MemberShipManageDto {

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
	
	
}
