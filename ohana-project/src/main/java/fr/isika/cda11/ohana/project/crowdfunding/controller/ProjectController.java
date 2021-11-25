package fr.isika.cda11.ohana.project.crowdfunding.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.crowdfunding.models.Funder;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.service.ProjectService;



@ManagedBean(name = "projectMB")
@SessionScoped
public class ProjectController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3215220252137288317L;

	@Inject
	ProjectService projectService;
	
	@Inject
	AssociationService associationService;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTheProject(Project theProject) {
		this.theProject = theProject;
	}

	public void setNewProject(Project newProject) {
		this.newProject = newProject;
	}

	Project theProject = new Project();
	Project newProject = new Project();
	
	List<Project> projectsByAssos = new ArrayList<Project>();
	
	List<Project> allProject = new ArrayList<Project>();
	
	public List<Project> getAllProject() {
		return allProject;
	}

	public void setAllProject(List<Project> allProject) {
		this.allProject = allProject;
	}

	public List<Project> getProjectsByAssos() {
		return projectsByAssos;
	}

	public void setProjectsByAssos(List<Project> projectsByAssos) {
		this.projectsByAssos = projectsByAssos;
	}

	public AssociationDto getAssociationDto() {
		return associationDto;
	}

	public void setAssociationDto(AssociationDto associationDto) {
		this.associationDto = associationDto;
	}

	AssociationDto associationDto = new AssociationDto();


	
	@PostConstruct
	public void init() {
		allProject = projectService.findListProjectsService();
		/*System.out.println("Create " + this);
		if (projectService.findListProjectsService().size() == 0) {
			
			Project p1 = new Project();
			p1.setName("Architecture JEE");
			p1.setFinancialGoal(500000);
			p1.setDescription("gros projet");
			p1.setAssociation(null);
			projectService.updateProjectService(p1);
		}*/
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
	
	public String createProject(Long id) {
		associationDto = associationService.findAssociationByIdService(Long.valueOf(id));
		newProject.setAssociation(AssociationFactory.fromAssociationDto(associationDto));
		projectService.createProjectService(newProject);
		projectsByAssos=new ArrayList<Project>();
		newProject = new Project();
		return listProjectByAssos(id);
	}
	
	public String listProjectByAssos(Long id)
	{
		associationDto = associationService.findAssociationByIdService(id);
		List<Project> allProjects = new ArrayList<Project>();
		allProjects = getProjects();
		for (Project project : allProjects)
		{
			if(project.getAssociation().getIdAssos() == id)
			{
				projectsByAssos.add(project);
			}
			
		}
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
	
	public Long duration(Long id){	
		Long duration = projectService.durationService(id);
		return duration;
	}
    
}