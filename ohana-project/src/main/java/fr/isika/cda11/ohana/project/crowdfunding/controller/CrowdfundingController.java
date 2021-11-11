package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.models.Person;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.repository.CrowdfundingRepository;



@ManagedBean(name = "projectMB")
@SessionScoped
public class CrowdfundingController {
	
	@Inject
	CrowdfundingRepository cr;
	
	Project theProject = new Project();
	Project newProject = new Project();
	Person thePerson = new Person();
	Funding theFunding = new Funding();

	
	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (cr.findProjects().size() == 0) {
			
			Project p1 = new Project();
			p1.setName("Architecture JEE");
			p1.setFinancialGoal(500000);
			p1.setDescription("gros projet");
			cr.saveProject(p1);
		}
	}

	public List<Project> getProjects() {
		return cr.findProjects();
	}
	public List<Funding> getFundings() {
		return cr.findFundings();
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

	public String show(Integer n) {
		theProject = cr.findProject(n);
		return "showProject";
	}

	public String deleteProject() {
		cr.deleteProject(theProject);
		return "projects";
	}
	public String save() {
		cr.saveProject(theProject);
		return "showProject";
	}

	public String newProject() {
		cr.saveProject(newProject);
		newProject = new Project();
		return "projects";
	}
	
	public String newFunding() {
		cr.saveFunding(theFunding);
		theFunding = new Funding();
		return "customerProjectList";
	}
}