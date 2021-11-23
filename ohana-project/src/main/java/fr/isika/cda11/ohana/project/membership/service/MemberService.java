package fr.isika.cda11.ohana.project.membership.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import fr.isika.cda11.ohana.project.common.dto.*;
import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.repository.PrivatePersonRepos;
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
	
	@Inject
	private PrivatePersonRepos privatePersonRepos;

	// CREATE
	public MemberDto createMember(MemberDto memberDto, MembershipDto membershipDto, ContactDto contactDto, InfoPersonDto infopersonDto, AccountDto accounDto, AddressDto addressDto) {
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
		memberDto.setMembershipDto(membershipDto);
		Member member= memberRepos.createMember(memberDto);
		MemberDto newMemberDto = MemberFactory.fromMember(member);
		membershipDto.getMembers().add(newMemberDto);
		return newMemberDto;
	}
	
	public MemberDto subMember(MembershipDto mbsDto, AccountDto accountDto) {
		PrivatePersonDto privatepersonDto= new PrivatePersonDto();
		List<PrivatePersonDto> allPrivatePersonDto = new ArrayList<PrivatePersonDto>();
		allPrivatePersonDto=privatePersonRepos.listPrivatePersonRepos();
		for(PrivatePersonDto privateperson: allPrivatePersonDto) {
			System.out.println(privateperson);
			if(privateperson.getAccount().getIdAccount()==accountDto.getIdAccount()) {
				privatepersonDto=privateperson;
				System.out.println(privatepersonDto.getIdPrivatePerson());
			}
		}
		MemberDto memberDto = new MemberDto();
		memberDto.setPrivatePerson(privatepersonDto);
		memberDto.setMembershipDto(mbsDto);
		Member member=memberRepos.subMember(memberDto, privatepersonDto);
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
		return findMemberByIdService(memberToUpdate.getIdMember());
	}

	// DELETE
	public void deleteMemberService(Long id) {
		memberRepos.deleteMemberRepos(id);
	}
}
