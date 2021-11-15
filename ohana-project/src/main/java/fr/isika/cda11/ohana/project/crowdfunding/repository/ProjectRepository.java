package fr.isika.cda11.ohana.project.crowdfunding.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.crowdfunding.models.Project;



@Stateless
public class ProjectRepository {

	@PersistenceContext
	EntityManager em;

	public List<Project> findProjectsRepos() {
		return em.createQuery("Select c From Project c", Project.class)
				.getResultList();
	}

	public Project findProjectRepos(Integer n) {
		return em.find(Project.class, Long.valueOf(n));
	}
	
	public void createProjectRepos(Project project) {
		em.persist(project);

	}

	public Project updateProjectRepos(Project c) {

		if (c.getId() == null) 
		{
			em.persist(c);
		} 
		else 
		{
			c = em.merge(c);
		}

		return c;
	}

	public void deleteProjectRepos(Project c) {
		c = em.merge(c);
		em.remove(c);
	}

}