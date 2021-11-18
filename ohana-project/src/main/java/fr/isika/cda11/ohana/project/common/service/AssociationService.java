package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;

@Stateless
public class AssociationService {
	@Inject
	private AssociationRepos associationRepos;
	
	
	//CREATE

	public void createAssociationService(AssociationDto associationDto, AddressDto addressDto) {
		associationDto.setAddressAsso(addressDto);
		associationRepos.createAssociationRepos(associationDto);
	}
	
	//READ

	public AssociationDto findAssociationByIdService(long id) {
		return associationRepos.findAssociationRepos(id);
	}

	public List<AssociationDto> listAssociationsService(){
		return associationRepos.listAssociationRepos();
	}
	
/*	public Association updateAssociationService(Association association) {
		associationRepos.updateAssociation(association);
		return findAssociation(association.getId());
	}*/
	
	
	//UPDATE
	public AssociationDto updateAssociationService(AssociationDto associationToUpdate) {
				
			associationRepos.updateAssociationRepos(associationToUpdate);
			return findAssociationByIdService(associationToUpdate.getIdAssos());

	}
	
	
	//DELETE
	public void deleteAssociationService(Long id) {
	
		associationRepos.deleteAssociationRepos(id);
	}
	
	


}
