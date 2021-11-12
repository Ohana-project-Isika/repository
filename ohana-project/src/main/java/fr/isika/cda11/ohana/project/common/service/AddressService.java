package fr.isika.cda11.ohana.project.common.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.repository.AddressRepos;

@Stateless
public class AddressService {

	@Inject
	private AddressRepos addressRepos;
	
	public void createAddressService(Address address) {

		addressRepos.createAddressRepos(address);
	}
}
