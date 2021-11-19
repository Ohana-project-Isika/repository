package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.ServicesDto;
import fr.isika.cda11.ohana.project.common.service.AccountService;
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
	@Inject
	private AccountService accountService;
	
	private AssociationDto nouvelAssociation = new AssociationDto();	
	private AssociationDto associationToUpdate = new AssociationDto();
	private AssociationDto association = new AssociationDto();
	private AddressDto nouvelAddresse = new AddressDto();
	private AccountDto accountDto = new AccountDto();
	private ServicesDto servicesDto = new ServicesDto();
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
	public AccountDto getAccountDto() {return accountDto;}
	public void setAccountDto(AccountDto accountDto) {this.accountDto = accountDto;}
	public List<AssociationDto> getAssociations() {return associations;}
	public void setAssociations(List<AssociationDto> associations) {this.associations = associations;}
	public ServicesDto getServicesDto() {return servicesDto;}
	public void setServicesDto(ServicesDto servicesDto) {this.servicesDto = servicesDto;}
	
	

	
	//METHODE CRUD---------------------------------------------------------------------------
	



	//Create
	public String subscription() {
		AssociationDto assosDto=associationService.createAssociationService(nouvelAssociation, nouvelAddresse, servicesDto, accountDto);
		nouvelAssociation=assosDto;
		associations=listAssociations();
		nouvelAddresse = new AddressDto();
		nouvelAssociation= new AssociationDto();
		return "associationTable";
	}
	
	public AccountDto createAccount(InfoPersonDto infoPerson, ContactDto contact, AddressDto address) {
		
		return accountDto;
		
	}

	//Read
	public AssociationDto findAssociationById(Long id) {
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
		associations=listAssociations();
		return "associationTable";
	}
	
	//Delete
	public String deleteAssociation(Long id) {
		associationService.deleteAssociationService(id);
		associations=listAssociations();
		return "associationTable";
	}
	
	
	//NAVIGATION-----------------------------------------------------------------------------------------
	
	//showAssociation.xhtml
	public String ShowAssociation(Long id) {
		nouvelAssociation=findAssociationById(id);
		return "showAssociation";
	}

	//updateAssociationForm.xhtml
	public String updateAssociationForm(Long id) {
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
