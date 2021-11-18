package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.models.Address;

public final class AddressFactory {

	private AddressFactory(){
		
	}
	
	public static Address fromAddressDto(AddressDto addressDto) {
		Address address= new Address();
		address.setNumRue(addressDto.getNumRue());
		address.setRue(addressDto.getRue());
		address.setCodePostal(addressDto.getCodePostal());
		address.setVille(addressDto.getVille());
		address.setPays(addressDto.getPays());
		address.setIdAddress(addressDto.getIdAddress());
		return address;
	}
	
	public static AddressDto fromAddress(Address address) {
		AddressDto addressDto= new AddressDto();
		addressDto.setNumRue(address.getNumRue());
		addressDto.setRue(address.getRue());
		addressDto.setCodePostal(address.getCodePostal());
		addressDto.setVille(address.getVille());
		addressDto.setPays(address.getPays());
		addressDto.setIdAddress(address.getIdAddress());
		return addressDto;
	}
	
}
