package fr.isika.cda11.ohana.project.common.factories;

import java.util.ArrayList;

import fr.isika.cda11.ohana.project.common.dto.PaiementDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.models.Paiement;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;

public class PrivatePersonFactory {
	private PrivatePersonFactory() {
		
	}

	
	public static PrivatePerson fromPrivatePersonDto(PrivatePersonDto privatePersonDto) {
		PrivatePerson privatePerson = new PrivatePerson();
		privatePerson.setPhotoProfil(privatePersonDto.getPhotoProfil());
		privatePerson.setAccount(AccountFactory.fromAccountDto(privatePersonDto.getAccount()));
		privatePerson.setPaiement(new ArrayList<Paiement>());
		privatePerson.setIdPrivatePerson(privatePersonDto.getIdPrivatePerson());

		return privatePerson;
	}
	
	public static PrivatePersonDto fromPrivatePerson(PrivatePerson privatePerson) {
		PrivatePersonDto privatePersonDto = new PrivatePersonDto();
		privatePersonDto.setPhotoProfil(privatePerson.getPhotoProfil());
		privatePersonDto.setAccount(AccountFactory.fromAccount(privatePerson.getAccount()));
		privatePersonDto.setPaiement(new ArrayList<PaiementDto>());
		privatePersonDto.setIdPrivatePerson(privatePerson.getIdPrivatePerson());
		return privatePersonDto;
	}
}
