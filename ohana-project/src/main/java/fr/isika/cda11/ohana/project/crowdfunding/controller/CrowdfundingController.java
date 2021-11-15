package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.models.Person;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.service.FundingService;
import fr.isika.cda11.ohana.project.crowdfunding.service.ProjectService;



@ManagedBean(name = "projectMB")
@SessionScoped
public class CrowdfundingController {
	
	@Inject
	ProjectService projectService;
	
	@Inject
	FundingService fundingService;
	
	Project theProject = new Project();
	Project newProject = new Project();
	Person thePerson = new Person();
	Funding theFunding = new Funding();

	
	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (projectService.findListProjectsService().size() == 0) {
			
			Project p1 = new Project();
			p1.setName("Architecture JEE");
			p1.setFinancialGoal(500000);
			p1.setDescription("gros projet");
			projectService.updateProjectService(p1);
		}
	}

	public List<Project> getProjects() {
	return projectService.findListProjectsService();
	}
	
	public List<Funding> getFundings() {
		return fundingService.findListFundingsService();
	}
	
	public Funding getTheFunding() {
		return theFunding;
	}

	public Person getThePerson() {
		return thePerson;
	}

	public Project getTheProject() {
		return theProject;
	}
	
	public Project getNewProject() {
		return newProject;
	}

	public String show(Integer id) {
		theProject = projectService.findProjectService(id);
		return "showProject";
	}

	public String createProject() {
		projectService.createProjectService(newProject);
		newProject = new Project();
		return "projects";
	}
	
	public String updateProject() {
		projectService.updateProjectService(theProject);
		return "showProject";
	}
	
	public String deleteProject() {
		projectService.deleteProjectService(theProject);
		return "projects";
	}
	
	public Long countFundings() {
		Long res = getFundings().stream().count();
		return res;
	}
	
	public String finance(Integer id) {
		
		Project p = projectService.findProjectService(id);
		theFunding.setProject(p);
		p.addFunding(theFunding);
		return "financeProject?faces-redirect=true";
	}
	
	public String payer() {		
		
		fundingService.updateFundingService(theFunding);
		theFunding = new Funding();
		return "customerProjectList";
	}
}