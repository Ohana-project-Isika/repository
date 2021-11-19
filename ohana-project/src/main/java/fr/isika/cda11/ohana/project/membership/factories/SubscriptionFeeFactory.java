package fr.isika.cda11.ohana.project.membership.factories;

import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.models.Member;

public class SubscriptionFeeFactory {
	public static Member fromMemberDto(MemberDto memberDto) {
		Member member = new Member();
		return member;
	}

}
