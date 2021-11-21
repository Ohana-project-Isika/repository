package fr.isika.cda11.ohana.project.common.factories;


import java.util.ArrayList;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.InfoPerson;

public class InfoPersonFactory {

	private InfoPersonFactory() {
		
	}

	
	public static InfoPerson fromInfoPersonDto(InfoPersonDto infoPersonDto) {
		InfoPerson infoPerson = new InfoPerson();
		infoPerson.setLastName(infoPersonDto.getLastName());
		infoPerson.setFirstName(infoPersonDto.getFirstName());
		infoPerson.setDateOfBirth(infoPersonDto.getDateOfBirth());
		infoPerson.setContact(ContactFactory.fromContactDto(infoPersonDto.getContact()));
		infoPerson.setAddress(AddressFactory.fromAddressDto(infoPersonDto.getAddress()));
		infoPerson.setIdInfoPers(infoPersonDto.getIdInfoPers());

		return infoPerson;
	}
	
	public static InfoPersonDto fromInfoPerson(InfoPerson infoPerson) {
		InfoPersonDto infoPersonDto = new InfoPersonDto();
		infoPersonDto.setLastName(infoPerson.getLastName());
		infoPersonDto.setFirstName(infoPerson.getFirstName());
		infoPersonDto.setDateOfBirth(infoPerson.getDateOfBirth());
		infoPersonDto.setContact(ContactFactory.fromContact(infoPerson.getContact()));
		infoPersonDto.setAddress(AddressFactory.fromAddress(infoPerson.getAddress()));
		infoPersonDto.setIdInfoPers(infoPerson.getIdInfoPers());
		return infoPersonDto;
	}
}
