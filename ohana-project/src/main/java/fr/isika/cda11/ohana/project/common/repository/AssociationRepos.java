package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.models.Association;

@Stateless
public class AssociationRepos {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createAssociationRepos(Association association) {
		entityManager.persist(association);
	}
	
	public Association findAssociationRepos(long id) {

			return entityManager.find(Association.class, id);
		
	}
	

	
}
