package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;
import fr.isika.cda11.ohana.project.common.service.AddressService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;

@ManagedBean
@SessionScoped

public class AssociationController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3051399597928139417L;
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Inject
	private AddressService addressService;
	
	@Inject
	private AssociationService associationService;
	
	@Inject
	AssociationRepos associationrepos;
	
	private Association nouvelAssociation = new Association();
	
	private Address nouvelAddresse = new Address();
	
	

	public Association getNouvelAssociation() {
		return nouvelAssociation;
	}

	public void setNouvelAssociation(Association nouvelAssociation) {
		this.nouvelAssociation = nouvelAssociation;
	}

	public Address getNouvelAddresse() {
		return nouvelAddresse;
	}

	public void setNouvelAddresse(Address nouvelAddresse) {
		this.nouvelAddresse = nouvelAddresse;
	}

	public String subscription() {
		addressService.createAddressService(nouvelAddresse);

		nouvelAssociation.setAddress(nouvelAddresse);
		associationService.createAssociationService(nouvelAssociation);
		
		return "subscriptionvalidate?faces-redirect=true";
	}
	
	public String findAssos() {
		Association assos= associationService.findAssociatin(2);
		return assos.toString();
	}
	

	
	/*public String subscriptiontest() {
		addressService.createAddressService(nouvelAddresse);

		nouvelAssociation.setAddress(nouvelAddresse);
		associationService.createAssociationService(nouvelAssociation);
	
		return "subscriptionvalidate?faces-redirect=true";
	}*/
	
	public static void main(String[] args) {
		

		
	}

}
