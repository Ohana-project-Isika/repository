package fr.isika.cda11.ohana.project.crowdfunding.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.repository.CrowdfundingRepository;

@Stateless
public class ProjectService {

	@Inject
	private CrowdfundingRepository crowdfundingRepos ;
	

	public void createProjectService(Project project) {

		crowdfundingRepos.createProjectRepos(project);

	}
	
	public void updateProjectService(Project project) {
		
		crowdfundingRepos.updateProjectRepos(project);
		
	}
	
	public void deleteProjectService(Project project) {
		
		crowdfundingRepos.deleteProjectRepos(project);
		
	}
	


	
	
	
}
