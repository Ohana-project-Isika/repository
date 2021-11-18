package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.models.Contact;

public class ContactFactory {
	private ContactFactory() {
		
	}

	
	public static Contact fromContactDto(ContactDto contactDto) {
		Contact contact = new Contact();
		contact.setPhoneNb(contactDto.getPhoneNb());
		contact.setPhoneNb2(contactDto.getPhoneNb2());
		contact.setEmail(contactDto.getEmail());
		contact.setIdContact(contactDto.getIdContact());

		return contact;
	}
	
	public static ContactDto fromContact(Contact contact) {
		ContactDto contactDto = new ContactDto();
		contactDto.setPhoneNb(contact.getPhoneNb());
		contactDto.setPhoneNb2(contact.getPhoneNb2());
		contactDto.setEmail(contact.getEmail());
		contactDto.setIdContact(contact.getIdContact());

		return contactDto;
	}
}
