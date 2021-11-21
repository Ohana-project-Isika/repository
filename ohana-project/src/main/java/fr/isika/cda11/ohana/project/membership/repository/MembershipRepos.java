package fr.isika.cda11.ohana.project.membership.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MembershipFactory;
import fr.isika.cda11.ohana.project.membership.models.MemberShipManage;
import fr.isika.cda11.ohana.project.membership.models.Membership;

@Stateless
public class MembershipRepos {

	@PersistenceContext
	private EntityManager entityManager;
	
	//CREATE
	public Membership createMembership(MembershipDto membershipDto, MemberShipManageDto mbsm) {
		membershipDto.setMemberShipManage(mbsm);
		Membership membership= MembershipFactory.fromMembershipDto(membershipDto);
		entityManager.persist(membership);
		MemberShipManage membershipmanage = entityManager.find(MemberShipManage.class, mbsm.getId());
		membership.setMemberShipManage(membershipmanage);
		return membership;
	}
	
	//READ
	
	public MembershipDto findMembershipRepos(Long id) {
		Membership membership = entityManager.find(Membership.class, id);
		return MembershipFactory.fromMembership(membership);	
	}

	public List<MembershipDto> listMembershipRepos(){
		return this.entityManager.createNamedQuery("membership.findAll", Membership.class)
				.getResultList()
				.stream()
				.map(membership -> MembershipFactory.fromMembership(membership))
				.collect(Collectors.toList());
	}
	
	//UPDATE
	
	public Membership updateMembershipRepos(MembershipDto membershipDto) {
		Membership membership = MembershipFactory.fromMembershipDto(membershipDto);
		return entityManager.merge(membership);
	}
	
	//DELETE
	
	public void deleteMembershipRepos(Long id) {
		Membership membership = entityManager.find(Membership.class, id);
			entityManager.remove(membership);
	}
}
