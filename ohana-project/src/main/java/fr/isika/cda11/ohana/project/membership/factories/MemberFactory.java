package fr.isika.cda11.ohana.project.membership.factories;


import java.util.ArrayList;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.SubscriptionFeeDto;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.SubscriptionFee;


public class MemberFactory {
	public static Member fromMemberDto(MemberDto memberDto) {
		Member member = new Member();
		member.setPrivatePerson(PrivatePersonFactory.fromPrivatePersonDto(memberDto.getPrivatePerson()));
		member.setIdMember(memberDto.getIdMember());
		member.setDateOfStart(memberDto.getDateOfStart());
		member.setDateOfEnd(memberDto.getDateOfEnd());
		return member;
	}
	
	public static MemberDto fromMember(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setPrivatePerson(PrivatePersonFactory.fromPrivatePerson(member.getPrivatePerson()));
		memberDto.setIdMember(Long.valueOf(member.getIdMember()));
		memberDto.setDateOfStart(member.getDateOfStart());
		memberDto.setDateOfEnd(member.getDateOfEnd());
		return memberDto;
	}
}
