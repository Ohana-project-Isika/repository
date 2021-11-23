package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.factories.AssociationFactory;
import fr.isika.cda11.ohana.project.common.factories.InfoPersonFactory;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.models.InfoPerson;

@Stateless
public class InfoPersonRepos {

	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createInfoPersonRepos(InfoPersonDto infoPersonDto) {
		InfoPerson infoPerson = InfoPersonFactory.fromInfoPersonDto(infoPersonDto);
		entityManager.persist(infoPerson);
	}

	//READ
	public InfoPersonDto findInfoPersonByIdRepos(Long id) {

		InfoPersonDto infoPersonDto= InfoPersonFactory.fromInfoPerson(entityManager.find(InfoPerson.class, id));	
		return infoPersonDto;
	}

	public List<InfoPersonDto> listInfoPersonRepos(){
		return this.entityManager.createNamedQuery("infoPerson.findAll", InfoPerson.class).getResultList().stream().map(infoPerson -> InfoPersonFactory.fromInfoPerson(infoPerson)).collect(Collectors.toList());
	}

	//UPDATE
	public InfoPerson updateInfoPersonRepos(InfoPersonDto infoPersonToUpdate) {
		InfoPerson infoPerson = InfoPersonFactory.fromInfoPersonDto(infoPersonToUpdate);
		return entityManager.merge(infoPerson);
	}
	
	//DELETE
	
	public void deleteInfoPersonRepos(Long id) {
		InfoPerson infoPerson = entityManager.find(InfoPerson.class, id);
		if(infoPerson != null) {
			entityManager.remove(infoPerson);
		}
	}
	
}
