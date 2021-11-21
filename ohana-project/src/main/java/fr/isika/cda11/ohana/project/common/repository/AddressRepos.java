package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.factories.AddressFactory;
import fr.isika.cda11.ohana.project.common.models.Address;

@Stateless
public class AddressRepos {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//CREATE
	public void createAddressRepos(AddressDto addressDto) {
		Address address = AddressFactory.fromAddressDto(addressDto);
		entityManager.persist(address);		
	}
	
	
	//UPDATE
	public Address updateAddressRepos(AddressDto addressDto) {
		Address address = AddressFactory.fromAddressDto(addressDto);
		return entityManager.merge(address);
	}
	
	//READ
	public AddressDto findAddressByIdRepos(Long id) {
		return AddressFactory.fromAddress(entityManager.find(Address.class, id));
	}

	public List<AddressDto> listAddressRepos() {
		return this.entityManager.createNamedQuery("address.findAll", Address.class)
				.getResultList()
				.stream()
				.map(address -> AddressFactory.fromAddress(address))
				.collect(Collectors.toList());
	}
	
	//DELETE
	
	public void deleteAddressRepos(Long id) {
		Address address = entityManager.find(Address.class, id);
		if (address != null) {
			entityManager.remove(address);
		}
	}
	
}
