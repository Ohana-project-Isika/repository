package fr.isika.cda11.ohana.project.membership.factories;

import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.models.Membership;

public class MembershipFactory {
	public static Membership fromMembershipDto(MembershipDto membershipDto) {
		Membership membership = new Membership();
		membership.setNameMbs(membershipDto.getNameMbs());
		membership.setPriceOfFee(membershipDto.getPriceOfFee());
		membership.setMemberShipManage(MemberShipManageFactory.fromMembershipManageDto(membershipDto.getMemberShipManage()));
		membership.setIdMbs(membershipDto.getIdMbs());
		return membership;
	}
	
	public static MembershipDto fromMembership(Membership membership) {
		MembershipDto membershipDto = new MembershipDto();
		membershipDto.setNameMbs(membership.getNameMbs());
		membershipDto.setPriceOfFee(membership.getPriceOfFee());
		membershipDto.setMemberShipManage(MemberShipManageFactory.fromMembershipManage(membership.getMemberShipManage()));
		membershipDto.setIdMbs(Long.valueOf(membership.getIdMbs()));
		return membershipDto;
	}
}
