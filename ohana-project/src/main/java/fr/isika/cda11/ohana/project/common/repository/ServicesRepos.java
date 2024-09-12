package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.dto.ServicesDto;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.factories.ServicesFactory;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.common.models.Services;

@Stateless
public class ServicesRepos {
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createServicesRepos(ServicesDto servicesDto) {
		Services services = ServicesFactory.fromServicesDto(servicesDto);
		entityManager.persist(services);
	}

	//READ
	public ServicesDto findServicesRepos(Long id) {

		ServicesDto servicesDto= ServicesFactory.fromServices(entityManager.find(Services.class, id));	
		return servicesDto;
	}

	public List<ServicesDto> listServicesRepos(){
		return this.entityManager.createNamedQuery("privatePerson.findAll", Services.class).getResultList().stream().map(services -> ServicesFactory.fromServices(services)).collect(Collectors.toList());
	}

	//UPDATE
	public Services updateServicesRepos(ServicesDto servicesToUpdate) {
		Services services = ServicesFactory.fromServicesDto(servicesToUpdate);
		return entityManager.merge(services);
	}

	//DELETE

	public void deleteServicesRepos(Long id) {
		Services services = entityManager.find(Services.class, id);
		if(services != null) {
			entityManager.remove(services);
		}
	}
}
