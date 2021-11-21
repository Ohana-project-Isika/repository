package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;

@Stateless
public class PrivatePersonRepos {
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createPrivatePersonRepos(PrivatePersonDto privatePersonDto) {
		PrivatePerson privatePerson = PrivatePersonFactory.fromPrivatePersonDto(privatePersonDto);
		entityManager.persist(privatePerson);
	}

	//READ
	public PrivatePersonDto findPrivatePersonRepos(Long id) {

		PrivatePersonDto privatePersonDto= PrivatePersonFactory.fromPrivatePerson(entityManager.find(PrivatePerson.class, id));	
		return privatePersonDto;
	}

	public List<PrivatePersonDto> listPrivatePersonRepos(){
		return this.entityManager.createNamedQuery("privatePerson.findAll", PrivatePerson.class).getResultList().stream().map(privatePerson -> PrivatePersonFactory.fromPrivatePerson(privatePerson)).collect(Collectors.toList());
	}

	//UPDATE
	public PrivatePerson updatePrivatePersonRepos(PrivatePersonDto privatePersonToUpdate) {
		PrivatePerson privatePerson = PrivatePersonFactory.fromPrivatePersonDto(privatePersonToUpdate);
		return entityManager.merge(privatePerson);
	}

	//DELETE

	public void deletePrivatePersonRepos(Long id) {
		PrivatePerson privatePerson = entityManager.find(PrivatePerson.class, id);
		if(privatePerson != null) {
			entityManager.remove(privatePerson);
		}
	}
}
