package fr.isika.cda11.ohana.project.crowdfunding.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	public Project findProjectService(Long id) {
//		System.out.println("service id:" +id);
//		Project project = new Project();
		Project project=projectRepos.findProjectRepos(id);
//		System.out.println(project.toString());
		return project;
		
	}
	
	public List<Project> findListProjectsService() {
		
		return projectRepos.findProjectsRepos();
		
	}
	
	public Long durationService(Long id) {
		Project p = projectRepos.findProjectRepos(id);
		if (p.getStartDate()!=null && p.getEndDate()!=null) {
			Long duration = p.getEndDate().getTime() - p.getStartDate().getTime();
			return TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
		}
		return null;
	}
	
}
