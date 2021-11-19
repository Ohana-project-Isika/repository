package fr.isika.cda11.ohana.project.membership.factories;


import java.util.ArrayList;

import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.SubscriptionFeeDto;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.SubscriptionFee;


public class MemberFactory {
	public static Member fromMemberDto(MemberDto memberDto) {
		Member member = new Member();
		member.setPrivatePerson(memberDto.getPrivatePerson());
		member.setIdMember(memberDto.getIdMember());
		member.setSubscriptionFeeList(new ArrayList<SubscriptionFee>());
		if(memberDto.getSubscriptionFeeList().isEmpty()!=true) {
			for(SubscriptionFeeDto subdto : memberDto.getSubscriptionFeeList()) {
				member.getSubscriptionFeeList().add(SubscriptionFeeFactory.fromSubscriptionFeeDto(subdto));
			}
		}
		return member;
	}
	
	public static MemberDto fromMember(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setPrivatePerson(member.getPrivatePerson());
		memberDto.setIdMember(Long.valueOf(member.getIdMember()));
		memberDto.setSubscriptionFeeList(new ArrayList<SubscriptionFeeDto>());
		if(member.getSubscriptionFeeList().isEmpty()!=true) {
			for(SubscriptionFee sub : member.getSubscriptionFeeList()) {
				memberDto.getSubscriptionFeeList().add(SubscriptionFeeFactory.fromSubscriptionFee(sub));
			}
		}
		return memberDto;
	}
}
