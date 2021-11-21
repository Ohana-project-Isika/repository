package fr.isika.cda11.ohana.project.membership.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;
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
	public MemberDto createMember(MemberDto memberDto, MembershipDto membershipDto, ContactDto contactDto, InfoPersonDto infopersonDto, AccountDto accounDto) {
		infopersonDto.setContact(contactDto);
		//valeur par default du login = email
		accounDto.setAccountLogin(contactDto.getEmail());
		//valeur par default lors de l'ajout d'un membre par une association
		accounDto.setAccountPassword("0000");
		accounDto.setAccountCreationDate(new Date());
		accounDto.setRole(EnumRole.PRIVATEPERSON);
		
		accounDto.setInfoPerson(infopersonDto);
		PrivatePersonDto privatepersonDto= new PrivatePersonDto();
		privatepersonDto.setAccount(accounDto);
		memberDto.setPrivatePerson(privatepersonDto);
		Member member= memberRepos.createMember(memberDto, membershipDto);
		MemberDto newMemberDto = MemberFactory.fromMember(member);
		membershipDto.getMembers().add(newMemberDto);
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
		return findMemberByIdService(memberToUpdate.getIdMember());
	}

	// DELETE
	public void deleteMemberService(Long id) {
		memberRepos.deleteMemberRepos(id);
	}
}
