package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

	
	public List<Project> getProjects() {
		return projectService.findListProjectsService();
	}
	
	public List<Funding> getFundings() {
		return fundingService.findListFundingsService();
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
	
	
	public String finance(Long id) {
		
		Project p = projectService.findProjectService(id);
		theFunding.setProject(p);
		p.addFunding(theFunding);
		return "financeProject?faces-redirect=true";
	}
	
	public String payer() {		
		
		// vérifier que le mt de theFunding ne dépasse pas ce qu'on a récolté
		
		Long idProject = theFunding.getProject().getId();
		double financialGoal = theFunding.getProject().getFinancialGoal();
		System.out.println("récolte :  " + financialGoal);

		if(theFunding.getFundingAmount() <= getFundingAmountMax(idProject, financialGoal)) {
		
			fundingService.updateFundingService(theFunding);
			theFunding = new Funding();
			return "customerProjectList";
			
		} else {
			
			// afficher un message d'erreur ppur le champ montant
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Montant maximum atteint", 
					"Vous avez atteint le montant maximum de récolte de fonds pour ce projet"));
			
			// ensuite revenir sur la même page
			return "financeProject";
		}
	}
	
	
	public Long countFundings(Long id) {
		Project p = projectService.findProjectService(id);
		Long res = p.getFundings().stream().count();
		return res;
	}
	
	public double getActualsFundingsProject(Long idProject) {
		Project p = projectService.findProjectService(idProject);
		List<Funding> res = p.getFundings();
		int amount = 0;
		
		 for (Funding funding : res)
         {
             amount += funding.getFundingAmount();
         }
         return amount;
	}

	public double getFundingAmountMax(Long idProject, double financialGoal) {
		double amount = getActualsFundingsProject(idProject);
        return financialGoal - amount;
    }
    
}