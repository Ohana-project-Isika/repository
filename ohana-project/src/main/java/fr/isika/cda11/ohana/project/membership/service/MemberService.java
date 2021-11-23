package fr.isika.cda11.ohana.project.membership.service;

import fr.isika.cda11.ohana.project.common.dto.*;
import fr.isika.cda11.ohana.project.enumclass.EnumRole;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MemberFactory;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.repository.MemberRepos;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class MemberService {

    @Inject
    private MemberRepos memberRepos;

    // CREATE
    public MemberDto createMember(MemberDto memberDto, MembershipDto membershipDto, ContactDto contactDto, InfoPersonDto infopersonDto, AccountDto accounDto, AddressDto adressDto) {
        infopersonDto.setContact(contactDto);
        infopersonDto.setAddress(adressDto);
        //valeur par default du login = email
        accounDto.setAccountLogin(contactDto.getEmail());
        //valeur par default lors de l'ajout d'un membre par une association
        accounDto.setAccountPassword("0000");
        accounDto.setAccountCreationDate(new Date());
        accounDto.setRole(EnumRole.PARTICULIER);
        accounDto.setInfoPerson(infopersonDto);
        PrivatePersonDto privatepersonDto= new PrivatePersonDto();
        privatepersonDto.setAccount(accounDto);
        memberDto.setPrivatePerson(privatepersonDto);
        memberDto.setMembershipDto(membershipDto);
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
        return findMemberByIdService(memberToUpdate.getIdMember());
    }

    // DELETE
    public void deleteMemberService(Long id) {
        memberRepos.deleteMemberRepos(id);
    }
}
