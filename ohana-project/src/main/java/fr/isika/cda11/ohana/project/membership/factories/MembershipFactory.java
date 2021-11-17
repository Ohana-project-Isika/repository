package fr.isika.cda11.ohana.project.membership.factories;

import java.util.ArrayList;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.Membership;

public class MembershipFactory {
	public static Membership fromMembershipDto(MembershipDto membershipDto) {
		Membership membership = new Membership();
		return membership;
	}
	
	public static MembershipDto fromMembership(Membership membership) {
		MembershipDto membershipDto = new MembershipDto();
		membershipDto.setName(membershipDto.getName());
		membershipDto.setMembersDto(new ArrayList<MemberDto>());
		
//		if(membership.getMembers()!=null) {
//			for(Member members: membership.getMembers()) {
//				membershipDto.getMembersDto().add(MemberFactory.fromMember(members));
//			}
//		}
//		membershipDto.setId(membership.getId());
		return membershipDto;
	}
}
