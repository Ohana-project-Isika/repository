package fr.isika.cda11.ohana.project.membership.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.factories.MemberShipManageFactory;
import fr.isika.cda11.ohana.project.membership.models.MemberShipManage;

@Stateless
public class MemberShipManageRepos {

	@PersistenceContext
	private EntityManager entityManager;

	// CREATE
	public MemberShipManage createMembershipManage(MemberShipManageDto membershipManageDto) {
		MemberShipManage membershipManage = MemberShipManageFactory.fromMembershipManageDto(membershipManageDto);
		entityManager.persist(membershipManage);
		return membershipManage;
	}

	// READ

	public MemberShipManageDto findMembershipManageRepos(Long id) {
		MemberShipManage memberShipManage = entityManager.find(MemberShipManage.class, id);
		return MemberShipManageFactory.fromMembershipManage(memberShipManage);
	}
	
	public List<MemberShipManageDto> listMembershipManageRepos(){
		return this.entityManager.createNamedQuery("membershipmanages.findAll", MemberShipManage.class).getResultList().stream().map(membershipmanage -> MemberShipManageFactory.fromMembershipManage(membershipmanage)).collect(Collectors.toList());
	}

	// UPDATE

	public MemberShipManage updateMembershipManageRepos(MemberShipManageDto membershipManageDto) {
		MemberShipManage membershipManage = MemberShipManageFactory.fromMembershipManageDto(membershipManageDto);
		return entityManager.merge(membershipManage);
	}

	// DELETE

	public void deleteMembershipManageRepos(Long id) {
		MemberShipManage membershipManage = entityManager.find(MemberShipManage.class, id);
		if (membershipManage != null) {
			/*
			 * for(Member member : membership.getMembers()) { entityManager.remove(member);
			 * }
			 */
			entityManager.remove(membershipManage);
		}
	}

}
