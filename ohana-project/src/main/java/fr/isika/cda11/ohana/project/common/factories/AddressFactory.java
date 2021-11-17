package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.models.Address;

public final class AddressFactory {

	private AddressFactory(){
		
	}
	
	public static Address fromAddressDto(AddressDto addressDto) {
		Address address= new Address();
		address.setNumRue(addressDto.getNumber());
		address.setRue(addressDto.getStreet());
		address.setCodePostal(addressDto.getDepartment());
		address.setVille(addressDto.getCity());
		address.setIdAddress(addressDto.getId());
		return address;
	}
	
	public static AddressDto fromAddress(Address address) {
		AddressDto addressDto= new AddressDto();
		addressDto.setNumber(address.getNumRue());
		addressDto.setStreet(address.getRue());
		addressDto.setDepartment(address.getCodePostal());
		addressDto.setCity(address.getVille());
		addressDto.setId(address.getIdAddress());
		return addressDto;
	}
	
}
