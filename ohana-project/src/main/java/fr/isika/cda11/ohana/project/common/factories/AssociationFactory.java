package fr.isika.cda11.ohana.project.common.factories;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;

public final class AssociationFactory {
	
	private AssociationFactory() {
		
	}

	
	public static Association fromAssociationDto(AssociationDto associationDto) {
		Association association = new Association();
		association.setNameAssos(associationDto.getNameAssos());
		association.setValidateStatusAsso(associationDto.getValidateStatusAsso());
		association.setLogoAsso(associationDto.getLogoAsso());
		association.setJustifAsso(associationDto.getJustifAsso());
		association.setNumSiret(associationDto.getNumSiret());
		association.setAddressAsso(AddressFactory.fromAddressDto(associationDto.getAddressAsso()));
		association.setServices(ServicesFactory.fromServicesDto(associationDto.getServices()));
		association.setAccount(AccountFactory.fromAccountDto(associationDto.getAccount()));
		association.setIdAssos(associationDto.getIdAssos());
		return association;
	}
	
	public static AssociationDto fromAssociation(Association association) {
		AssociationDto associationDto = new AssociationDto();
		associationDto.setNameAssos(association.getNameAssos());
		associationDto.setValidateStatusAsso(association.getValidateStatusAsso());
		associationDto.setLogoAsso(association.getLogoAsso());
		associationDto.setJustifAsso(association.getJustifAsso());
		associationDto.setNumSiret(association.getNumSiret());
		associationDto.setAddressAsso(AddressFactory.fromAddress(association.getAddressAsso()));
		associationDto.setServices(ServicesFactory.fromServices(association.getServices()));
		associationDto.setAccount(AccountFactory.fromAccount(association.getAccount()));
		associationDto.setIdAssos(Long.valueOf(association.getIdAssos()));
		return associationDto;
	}
	

}
