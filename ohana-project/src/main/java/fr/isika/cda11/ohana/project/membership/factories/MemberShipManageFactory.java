package fr.isika.cda11.ohana.project.membership.factories;

import java.util.ArrayList;

import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.MemberShipManage;
import fr.isika.cda11.ohana.project.membership.models.Membership;

public class MemberShipManageFactory {

	public static MemberShipManage fromMembershipManageDto(MemberShipManageDto membershipManageDto) {
		MemberShipManage msm = new MemberShipManage();
		msm.setAssociation(AssociationFactory.fromAssociationDto(membershipManageDto.getAssociation()));
		msm.setId(membershipManageDto.getId());
		msm.setMemberships(new ArrayList<Membership>());
		return msm;
	}

	public static MemberShipManageDto fromMembershipManage(MemberShipManage membershipManage) {
		MemberShipManageDto msmDto = new MemberShipManageDto();
		msmDto.setAssociation(AssociationFactory.fromAssociation(membershipManage.getAssociation()));
		msmDto.setId(Long.valueOf(membershipManage.getId()));
		msmDto.setMemberships(new ArrayList<MembershipDto>());
		return msmDto;
	}
}
