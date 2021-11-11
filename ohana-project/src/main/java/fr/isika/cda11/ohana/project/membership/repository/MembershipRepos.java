package fr.isika.cda11.ohana.project.membership.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.membership.models.Membership;

@Stateless
public class MembershipRepos {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void createMembership(Membership membership) {
		entityManager.persist(membership);
	}
}
