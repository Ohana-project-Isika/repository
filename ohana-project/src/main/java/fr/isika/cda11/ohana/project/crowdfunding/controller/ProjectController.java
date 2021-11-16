package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Person;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.service.ProjectService;



@ManagedBean(name = "projectMB")
@SessionScoped
public class ProjectController {
	
	@Inject
	ProjectService projectService;
	
	Project theProject = new Project();
	Project newProject = new Project();
	Person thePerson = new Person();


	
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

	
	public Person getThePerson() {
		return thePerson;
	}

	public Project getTheProject() {
		return theProject;
	}
	
	public Project getNewProject() {
		return newProject;
	}
	
	public List<Project> getProjects() {
		return projectService.findListProjectsService();
	}
	
	
	
	public String createProject() {
		projectService.createProjectService(newProject);
		newProject = new Project();
		return "projects";
	}
	
	public String showProject(Long id) {
		theProject = projectService.findProjectService(id);
		return "showProject";
	}
	
	public String updateProject() {
		projectService.updateProjectService(theProject);
		return "projects";
	}
	
	public String deleteProject() {
		projectService.deleteProjectService(theProject);
		return "projects";
	}
	
	
	
	public String editProjectLink(Long id) {
		theProject = projectService.findProjectService(id);
		return "editProject";
	}
	
	public String deleteProjectLink(Long id) {
		theProject = projectService.findProjectService(id);
		return "deleteProject";
	}
    
}