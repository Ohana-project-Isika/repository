package fr.isika.cda11.ohana.project.crowdfunding.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;



@Stateless
public class CrowdfundingRepository {

	@PersistenceContext
	EntityManager em;

	public List<Project> findProjects() {
		return em.createQuery("Select c From Project c", Project.class)
				.getResultList();
	}
	
	public List<Funding> findFundings() {
		return em.createQuery("Select f From Funding f", Funding.class)
				.getResultList();
	}

	public Project findProject(Integer n) {
		return em.find(Project.class, Long.valueOf(n));
	}

	public Project saveProject(Project c) {
		if (c.getId() == null) {
			em.persist(c);
		} else {
			c = em.merge(c);
		}
		return c;
	}
	public Funding saveFunding(Funding f) {
		if (f.getId() == null) {
			em.persist(f);
		} else {
			f = em.merge(f);
		}
		return f;
	}

	public void deleteProject(Project c) {
		c = em.merge(c);
		em.remove(c);
	}
	
}