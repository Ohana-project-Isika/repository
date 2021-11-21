package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.ServicesDto;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AccountRepos;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;
import fr.isika.cda11.ohana.project.common.repository.ServicesRepos;
import fr.isika.cda11.ohana.project.membership.factories.MembershipFactory;

@Stateless
public class AssociationService {
	@Inject
	private AssociationRepos associationRepos;
	@Inject
	private AccountRepos accountRepos;
	@Inject
	private ServicesRepos servicesRepos;
	
	
	//CREATE

	public AssociationDto createAssociationService(AssociationDto associationDto, AddressDto addressDto, ServicesDto servicesDto, AccountDto accountDto) {
		servicesDto = servicesRepos.findServicesRepos(Long.valueOf(1));
		associationDto.setServices(servicesDto);
		associationDto.setAddressAsso(addressDto);
		associationDto.setAccount(accountDto);
		Association association = associationRepos.createAssociationRepos(associationDto);
		AssociationDto newassosDto= AssociationFactory.fromAssociation(association);
		return findAssociationByIdService(Long.valueOf(newassosDto.getIdAssos()));
	}
	

	
	//READ

	public AssociationDto findAssociationByIdService(Long id) {
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
			return findAssociationByIdService(Long.valueOf(associationToUpdate.getIdAssos()));

	}
	
	
	//DELETE
	public void deleteAssociationService(Long id) {
	
		associationRepos.deleteAssociationRepos(id);
	}
	
	


}
