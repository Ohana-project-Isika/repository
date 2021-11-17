package fr.isika.cda11.ohana.project.common.factories;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;

public final class AssociationFactory {
	
	private AssociationFactory() {
		
	}

	
	public static Association fromAssociationDto(AssociationDto associationDto) {
		Association association = new Association();
		association.setNameAssos(associationDto.getName());
		association.setAddressAsso(AddressFactory.fromAddressDto(associationDto.getAddress()));
		/*association.setAddress(new Address());
		association.getAddress().setNumber(associationDto.getAddress().getNumber());
		association.getAddress().setStreet(associationDto.getAddress().getStreet());
		association.getAddress().setCity(associationDto.getAddress().getCity());
		association.getAddress().setDepartment(associationDto.getAddress().getDepartment());*/	
		association.setIdAssos(associationDto.getId());
		return association;
	}
	
	public static AssociationDto fromAssociation(Association association) {
		AssociationDto associationDto= new AssociationDto();
		associationDto.setName(association.getNameAssos());
		associationDto.getAddress().setNumber(association.getAddressAsso().getNumRue());
		associationDto.getAddress().setStreet(association.getAddressAsso().getRue());
		associationDto.getAddress().setCity(association.getAddressAsso().getVille());
		associationDto.getAddress().setDepartment(association.getAddressAsso().getCodePostal());
		associationDto.setId(association.getIdAssos());
		return associationDto;
	}
	

}
