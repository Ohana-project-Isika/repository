package fr.isika.cda11.ohana.project.common.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.models.Address;

@Stateless
public class AddressRepos {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createAddressRepos(Address address) {
		entityManager.persist(address);
		
	}
}
