package fr.isika.cda11.ohana.project.membership.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MembershipFactory;
import fr.isika.cda11.ohana.project.membership.models.Membership;
import fr.isika.cda11.ohana.project.membership.repository.MembershipRepos;

@Stateless
public class MembershipService {

	@Inject
	private MembershipRepos membershiprepos;


	/*public Membership createMembership(String name, Association association) {
		Membership membership = new Membership();
		membership.setNameMbs(name);
	//	membership.setAssociation(association);
		return membership;
	}*/

	// CREATE
	public MembershipDto createMembership(MembershipDto membershipDto, MemberShipManageDto mbsm) {
		Membership membership = membershiprepos.createMembership(membershipDto, mbsm);
		MembershipDto newMembershipDto = MembershipFactory.fromMembership(membership);
		mbsm.getMemberships().add(newMembershipDto);
		return findMembershipByIdService(Long.valueOf(newMembershipDto.getIdMbs()));
	}

	// READ
	public MembershipDto findMembershipByIdService(Long id) {
		System.out.println("membershipservice id="+id);
		return membershiprepos.findMembershipRepos(id);
	}

	public List<MembershipDto> listMembershipsService() {
		return membershiprepos.listMembershipRepos();
	}

	public List<MembershipDto> listMembershiByManage(Long id) {
		List<Membership> memberships= membershiprepos.listMembershiByManage(id);
		List<MembershipDto> membershipsDto= new ArrayList<MembershipDto>();
		for(Membership membership: memberships) {
			MembershipDto membershipDto=MembershipFactory.fromMembership(membership);
			membershipsDto.add(membershipDto);
		}
		return membershipsDto;
	}

	// UPDATE
	public MembershipDto updateMembershipService(MembershipDto membershipToUpdate) {
		membershiprepos.updateMembershipRepos(membershipToUpdate);
		return findMembershipByIdService(membershipToUpdate.getIdMbs());
	}

	// DELETE
	public void deleteMembershipService(Long id) {
		membershiprepos.deleteMembershipRepos(id);
	}
}
