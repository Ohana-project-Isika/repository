package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.factories.ContactFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.Contact;

@Stateless
public class ContactRepos {

	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createContactRepos(ContactDto contactDto) {
		Contact contact = ContactFactory.fromContactDto(contactDto);
		entityManager.persist(contact);
	}

	//READ
	public ContactDto findContactRepos(Long id) {

		ContactDto contactDto= ContactFactory.fromContact(entityManager.find(Contact.class, id));	
		return contactDto;
	}

	public List<ContactDto> listContactRepos(){
		return this.entityManager.createNamedQuery("account.findAll", Contact.class).getResultList().stream().map(contact -> ContactFactory.fromContact(contact)).collect(Collectors.toList());
	}

	//UPDATE
	public Contact updateContactRepos(ContactDto contactToUpdate) {
		Contact contact = ContactFactory.fromContactDto(contactToUpdate);
		return entityManager.merge(contact);
	}

	//DELETE

	public void deleteContactRepos(Long id) {
		Contact contact = entityManager.find(Contact.class, id);
		if(contact != null) {
			entityManager.remove(contact);
		}
	}
}
