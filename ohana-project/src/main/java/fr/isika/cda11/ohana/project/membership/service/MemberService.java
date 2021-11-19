package fr.isika.cda11.ohana.project.membership.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MemberFactory;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.repository.MemberRepos;

@Stateless
public class MemberService {

	@Inject
	private MemberRepos memberRepos;

	// CREATE
	public MemberDto createMember(MemberDto memberDto, MembershipDto membershipDto) {
		membershipDto.getMembers().add(memberDto);
		Member member= memberRepos.createMember(memberDto);
		MemberDto newMemberDto = MemberFactory.fromMember(member);
		return newMemberDto;
	}

	// READ

	public MemberDto findMemberByIdService(Long id) {
		return memberRepos.findMemberRepos(id);
	}

	public List<MemberDto> listMembersService() {
		return memberRepos.listMemberRepos();
	}

	// UPDATE
	public MemberDto updateMemberService(MemberDto memberToUpdate) {
		memberRepos.updateMemberRepos(memberToUpdate);
		return findMemberByIdService(memberToUpdate.getId());
	}

	// DELETE
	public void deleteMemberService(Long id) {
		memberRepos.deleteMemberRepos(id);
	}
}
