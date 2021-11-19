package fr.isika.cda11.ohana.project.membership.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return MemberShipManageFactory.fromMembershipManage(entityManager.find(MemberShipManage.class, id));
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
