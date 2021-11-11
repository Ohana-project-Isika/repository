package fr.isika.cda11.ohana.project.membership.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MemberRepos {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void crrer() {
		
	}
	

}
