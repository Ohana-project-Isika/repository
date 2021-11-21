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
		membership.setNameMbs(membershipDto.getNameMbs());
		membership.setPriceOfFee(membershipDto.getPriceOfFee());
		membership.setMemberShipManage(MemberShipManageFactory.fromMembershipManageDto(membershipDto.getMemberShipManage()));
		membership.setMembers(new ArrayList<Member>());
		if(membershipDto.getMembers().isEmpty() ==false) {
			for(MemberDto member: membershipDto.getMembers()) {
				membership.getMembers().add(MemberFactory.fromMemberDto(member));
			}
		}
		membership.setIdMbs(membershipDto.getIdMbs());
		return membership;
	}
	
	public static MembershipDto fromMembership(Membership membership) {
		MembershipDto membershipDto = new MembershipDto();
		membershipDto.setNameMbs(membership.getNameMbs());
		membershipDto.setPriceOfFee(membership.getPriceOfFee());
		membershipDto.setMemberShipManage(MemberShipManageFactory.fromMembershipManage(membership.getMemberShipManage()));
		membershipDto.setMembers(new ArrayList<MemberDto>());
		if(membership.getMembers().isEmpty() ==false) {
			for(Member member: membership.getMembers()) {
				membershipDto.getMembers().add(MemberFactory.fromMember(member));
			}
		}
		membershipDto.setIdMbs(Long.valueOf(membership.getIdMbs()));
		return membershipDto;
	}
}
