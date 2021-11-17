package fr.isika.cda11.ohana.project.membership.factories;


import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.models.Member;


public class MemberFactory {
	public static Member fromMemberDto(MemberDto memberDto) {
		Member member = new Member();
		return member;
	}
	
	public static MemberDto fromMember(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setName(memberDto.getName());
		memberDto.setLastname(memberDto.getLastname());
		memberDto.setId(memberDto.getId());
		return memberDto;
	}
}
