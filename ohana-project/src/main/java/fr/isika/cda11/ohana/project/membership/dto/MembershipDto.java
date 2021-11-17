package fr.isika.cda11.ohana.project.membership.dto;

import java.util.ArrayList;
import java.util.List;

public class MembershipDto {

	private Long id;
	private String name;
	private List<MemberDto> membersDto = new ArrayList<MemberDto>();

	public MembershipDto() {
	}

	public MembershipDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MemberDto> getMembersDto() {
		return membersDto;
	}

	public void setMembersDto(List<MemberDto> membersDto) {
		this.membersDto = membersDto;
	}
}
