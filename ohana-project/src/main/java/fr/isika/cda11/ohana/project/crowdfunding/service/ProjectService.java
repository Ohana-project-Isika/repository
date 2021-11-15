package fr.isika.cda11.ohana.project.crowdfunding.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.repository.ProjectRepository;

@Stateless
public class ProjectService {

	@Inject
	private ProjectRepository projectRepos;
	

	public void createProjectService(Project project) {

		projectRepos.createProjectRepos(project);

	}
	
	public void updateProjectService(Project project) {
		
		projectRepos.updateProjectRepos(project);
		
	}
	
	public void deleteProjectService(Project project) {
		
		projectRepos.deleteProjectRepos(project);
		
	}
	
	public Project findProjectService(Integer id) {
		
		return projectRepos.findProjectRepos(id);
		
	}
	
	public List<Project> findListProjectsService() {
		
		return projectRepos.findProjectsRepos();
		
	}
	


	
	
	
}
