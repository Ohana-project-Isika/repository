package fr.isika.cda11.ohana.project.membership.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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


	public Membership createMembership(String name, Association association) {
		Membership membership = new Membership();
		membership.setNameMbs(name);
	//	membership.setAssociation(association);
		return membership;
	}

	// CREATE
	public MembershipDto createMembership(MembershipDto membershipDto, MemberShipManageDto mbsm) {
		mbsm.getMemberships().add(membershipDto);
		Membership membership = membershiprepos.createMembership(membershipDto, mbsm);
		MembershipDto newMembershipDto = MembershipFactory.fromMembership(membership);
		return findMembershipByIdService(newMembershipDto.getId());
	}

	// READ
	public MembershipDto findMembershipByIdService(Long id) {
		return membershiprepos.findMembershipRepos(id);
	}

	public List<MembershipDto> listMembershipsService() {
		return membershiprepos.listMembershipRepos();
	}

	// UPDATE
	public MembershipDto updateMembershipService(MembershipDto membershipToUpdate) {
		membershiprepos.updateMembershipRepos(membershipToUpdate);
		return findMembershipByIdService(membershipToUpdate.getId());
	}

	// DELETE
	public void deleteMembershipService(Long id) {
		membershiprepos.deleteMembershipRepos(id);
	}
}
