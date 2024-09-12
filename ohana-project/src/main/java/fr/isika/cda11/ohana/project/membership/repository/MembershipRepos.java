package fr.isika.cda11.ohana.project.membership.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.factories.MembershipFactory;
import fr.isika.cda11.ohana.project.membership.models.MemberShipManage;
import fr.isika.cda11.ohana.project.membership.models.Membership;

@Stateless
public class MembershipRepos {

	private static final String SELECT_MEMBERSHIP_BY_MEMBERSHIPMANAGE_ID= "SELECT a FROM Membership a WHERE a.MEMBERSHIPMANAGE_ID =:id";
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
		System.out.println("cherche lid:"+id);
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

    public List<Membership> listMembershiByManage(Long id) {
   List<MembershipDto> mbsDto = new ArrayList<MembershipDto>();
   List<Membership> mbs = new ArrayList<Membership>();
		  mbs= this.entityManager.createQuery(SELECT_MEMBERSHIP_BY_MEMBERSHIPMANAGE_ID, Membership.class).setParameter("id", id).getResultList();

   return mbs;
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
