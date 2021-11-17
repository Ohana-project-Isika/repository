package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;
import fr.isika.cda11.ohana.project.common.service.AddressService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;

@ManagedBean
@SessionScoped
public class AssociationController implements Serializable{

	//ATTRIBUTS-------------------------------------------------------------------------------------
	private static final long serialVersionUID = -3051399597928139417L;
	@Inject
	private AddressService addressService;	
	@Inject
	private AssociationService associationService;	
	private AssociationDto nouvelAssociation = new AssociationDto();	
	private AssociationDto associationToUpdate = new AssociationDto();
	private AssociationDto association = new AssociationDto();
	private AddressDto nouvelAddresse = new AddressDto();
	private List<AssociationDto> associations;
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.associations = associationService.listAssociationsService();
	}

	//GETTER AND SETTER	----------------------------------------------------------------------------
	public static long getSerialversionuid() {return serialVersionUID;}
	public AssociationDto getNouvelAssociation() {return nouvelAssociation;}
	public void setNouvelAssociation(AssociationDto nouvelAssociation) {this.nouvelAssociation = nouvelAssociation;}
	public AssociationDto getAssociationToUpdate() {return associationToUpdate;}
	public void setAssociationToUpdate(AssociationDto associationToUpdate) {this.associationToUpdate = associationToUpdate;}
	public AssociationDto getAssociation() {return association;}
	public void setAssociation(AssociationDto association) {this.association = association;}
	public AddressDto getNouvelAddresse() {return nouvelAddresse;}
	public void setNouvelAddresse(AddressDto nouvelAddresse) {this.nouvelAddresse = nouvelAddresse;}

	
	//METHODE CRUD---------------------------------------------------------------------------
	
	//Create
	public String subscription() {
		associationService.createAssociationService(nouvelAssociation, nouvelAddresse);
		nouvelAddresse = new AddressDto();
		nouvelAssociation= new AssociationDto();
		return "AssociationTable";
	}

	//Read
	public AssociationDto findAssociationById(long id) {
		AssociationDto associationDto= associationService.findAssociationByIdService(id);
		return associationDto;
	}
	
	public List<AssociationDto> listAssociations() {
		return associationService.listAssociationsService();
	}
	
	//Update
	public String updateAssociation(AssociationDto associationDto) {
		//nouvelAddresse=associationDto.getAddress();
		//addressService.deleteAddressService(nouvelAddresse.getId());
		associationToUpdate= associationService.updateAssociationService(associationDto);
		return "AssociationTable";
	}
	
	//Delete
	public String deleteAssociation(long id) {
		associationService.deleteAssociationService(id);
		return "AssociationTable";
	}
	
	
	//NAVIGATION-----------------------------------------------------------------------------------------
	
	//showAssociation.xhtml
	public String ShowAssociation(long id) {
		nouvelAssociation=findAssociationById(id);
		return "showAssociation";
	}

	//updateAssociationForm.xhtml
	public String updateAssociationForm(long id) {
		associationToUpdate=findAssociationById(id);
		return "updateAssociationForm";
	}









	public static void main(String[] args) {

	}


	/*
	 	public void init() {
		System.out.println("Create " + this);
		if (cm.findCourses().size() == 0) {
			Course c1 = new Course();
			c1.setName("Architecture JEE");
			c1.setHours(60);
			c1.setDescription("Introduction `a JEE.");
			cm.saveCourse(c1);
		}
	}
	public List<Course> getCourses() {
		return cm.findCourses();
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public String show(Long n) {
		theCourse = cm.findCourse(n);
		return "showCourse";
	}
	public String save() {
		if (theCourse.getHours() % 3 != 0) {
		FacesContext ct = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage("Hours is not multiple of 3");
		ct.addMessage("test:hours", msg);
		ct.validationFailed();
		return "editCourse";
		}
		cm.saveCourse(theCourse);
		return "showCourse";
		}

	public String newCourse() {
		theCourse = new Course();
		return "editCourse";
	}
	 */

}
