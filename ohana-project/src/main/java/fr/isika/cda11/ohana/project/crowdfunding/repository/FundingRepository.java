package fr.isika.cda11.ohana.project.crowdfunding.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funder;
import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;

@Stateless
public class FundingRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Funding> findFundingsRepos() {
		return em.createQuery("Select f From Funding f", Funding.class)
				.getResultList();
	}
	
	public Funding findFundingRepos(Long id) {
		return em.find(Funding.class, id);
	}
	
	public void createFundingRepos(Funding funding) {
		em.persist(funding);

	}
	
	public Funding updateFundingRepos(Funding f) {
		if (f.getId() == null) 
		{
			em.persist(f);
		} 
		else 
		{
			f = em.merge(f);
		}

		return f;
	}
	
	public Funder updateFunderRepos(Funder f) {
		if (f.getId() == null) 
		{
			em.persist(f);
		} 
		else 
		{
			f = em.merge(f);
		}
		
		return f;
	}
	
	public void deleteFundingRepos(Funding f) {
		f = em.merge(f);
		em.remove(f);
	}

}
