package fr.isika.cda11.ohana.project.membership.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MemberFactory;
import fr.isika.cda11.ohana.project.membership.factories.MembershipFactory;
import fr.isika.cda11.ohana.project.membership.models.Member;
import fr.isika.cda11.ohana.project.membership.models.Membership;

@Stateless
public class MemberRepos {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//CREATE
	public Member createMember(MemberDto memberDto) {
		//Long idMembsership en parametre
		// find membership by id
		Membership membership=entityManager.find(Membership.class, memberDto.getMembershipDto().getIdMbs());
		Member member = MemberFactory.fromMemberDto(memberDto);
		entityManager.persist(member);
		membership.getMembers().add(member);
		member.setMembership(membership);
		entityManager.merge(membership);
		return member;
		
		// add member entity to membership list
		
		
		//TODO Faut-il merge le membership ?
		// je ne crois pas, peut être que oui mais à tester !!
	}
	
	public Member subMember(MemberDto memberDto, PrivatePersonDto privatepersonDto) {
		Membership membership=entityManager.find(Membership.class, memberDto.getMembershipDto().getIdMbs());
		PrivatePerson privateperson= entityManager.find(PrivatePerson.class, privatepersonDto.getIdPrivatePerson());
		Member member = MemberFactory.fromMemberDto(memberDto);
		member.setPrivatePerson(privateperson);
		entityManager.persist(member);
		membership.getMembers().add(member);
		member.setMembership(membership);
		entityManager.merge(membership);
		return member;
	}
	
	//READ
	
	public MemberDto findMemberRepos(long id) {
		return MemberFactory.fromMember(entityManager.find(Member.class, id));	
	}

	public List<MemberDto> listMemberRepos(){
		return this.entityManager.createNamedQuery("member.findAll", Member.class)
				.getResultList()
				.stream()
				.map(member -> MemberFactory.fromMember(member))
				.collect(Collectors.toList());
	}
	
	//UPDATE
	
	public Member updateMemberRepos(MemberDto memberDto) {
		
		Member member= MemberFactory.fromMemberDto(memberDto);
		return entityManager.merge(member);
	}
	
	//DELETE
	
	public void deleteMemberRepos(Long id) {
		Member member = entityManager.find(Member.class, id);
		if(member !=null) {
			entityManager.remove(member);
		
		}
	}
	

}
