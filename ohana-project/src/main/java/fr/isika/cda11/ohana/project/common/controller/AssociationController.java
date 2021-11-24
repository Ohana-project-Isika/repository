package fr.isika.cda11.ohana.project.common.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.ServicesDto;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.AddressService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.membership.service.MemberShipManageService;


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
	@Inject
	MemberShipManageService mbsmService;
	
	private AssociationDto nouvelAssociation = new AssociationDto();	
	private AssociationDto associationToUpdate = new AssociationDto();
	private AssociationDto association = new AssociationDto();
	private AddressDto nouvelAddresse = new AddressDto();
	private AccountDto accountDto = new AccountDto();
	private ServicesDto servicesDto = new ServicesDto();
	private List<AssociationDto> associations;


	
	//---------------test
	private String folder = "C:\\Github\\Ohana\\ohana-project\\src\\main\\webapp\\resources\\logoAssociation\\";
	private Part uploadedFile;
	public Part getUploadedFile() {return uploadedFile;}
	public void setUploadedFile(Part uploadedFile) {this.uploadedFile = uploadedFile;}
	private String folder2 = "C:\\Github\\Ohana\\ohana-project\\src\\main\\webapp\\resources\\justification\\";
	private Part uploadedFile2;
	public Part getUploadedFile2() {return uploadedFile2;}
	public void setUploadedFile2(Part uploadedFile2) {this.uploadedFile2 = uploadedFile2;}
	
	//--------------fin test
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		associations=listAssociations();
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
	public String subscription(Long id) {
		accountDto=accountService.findAccountByIdService(id);
		saveFile();
		saveFile2();
		nouvelAssociation.setLogoAsso("../resources/logoAssociation/"+getFilename(uploadedFile));
		nouvelAssociation.setJustifAsso("../resources/Justification/"+getFilename(uploadedFile2));
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

	//upload file---------------------------

	public void saveFile() {

		System.out.println("saveFile method invoked..");
		System.out.println( "content-type:{0}" + uploadedFile.getContentType());
		System.out.println("filename:{0}" + uploadedFile.getName());
		System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
		System.out.println( "size:{0}" + uploadedFile.getSize());
		String fileName = "";

		try {

			fileName = getFilename(uploadedFile);

			System.out.println("fileName  " + fileName);

			uploadedFile.write(folder+fileName);


		} catch (IOException ex) {
			System.out.println(ex);


		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));

	}


	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}



	public void saveFile2() {

		System.out.println("saveFile method invoked..");
		System.out.println( "content-type:{0}" + uploadedFile2.getContentType());
		System.out.println("filename:{0}" + uploadedFile2.getName());
		System.out.println( "submitted filename:{0}"+ uploadedFile2.getSubmittedFileName());
		System.out.println( "size:{0}" + uploadedFile2.getSize());
		String fileName2 = "";

		try {

			fileName2 = getFilename2(uploadedFile2);

			System.out.println("fileName2  " + fileName2);

			uploadedFile2.write(folder2+fileName2);


		} catch (IOException ex) {
			System.out.println(ex);


		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName2+ " Uploaded!"));

	}


	private static String getFilename2(Part part2) {
		for (String cd : part2.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename2 = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename2.substring(filename2.lastIndexOf('/') + 1).substring(filename2.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}

	
	

	public static void main(String[] args) {

	}


//open file
	public void readPdf(Long id) {
		AssociationDto associationtoRead = findAssociationById(id);	
		readFile(associationtoRead.getJustifAsso());
	}
	
	
	public static void readFile(String file) {
		  try {

			File pdfFile = new File(file);
			if (pdfFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
				} else {
					System.out.println("Awt Desktop is not supported!");
				}

			} else {
				System.out.println("File is not exists!");
			}

			System.out.println("Done");

		  } catch (Exception ex) {
			ex.printStackTrace();
		  }

		}

}