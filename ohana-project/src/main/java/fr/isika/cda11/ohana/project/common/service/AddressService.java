package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.repository.AddressRepos;

@Stateless
public class AddressService {

	@Inject
	private AddressRepos addressRepos;
	
	//CREATE
	public void createAddressService(AddressDto addressDto) {

		addressRepos.createAddressRepos(addressDto);
	}
	
	//READ
	public AddressDto findAddressByIdService(long id) {
		return addressRepos.findAddressByIdRepos(id);
	}

	public List<AddressDto> listAddressService() {
		return addressRepos.listAddressRepos();
	}
	
	//UPDATE
	public AddressDto updateAddressService(AddressDto addressDto) {
		addressRepos.updateAddressRepos(addressDto);
		return findAddressByIdService(addressDto.getIdAddress());
	}

	//DELETE
	public void deleteAddressService(long id) {
		addressRepos.deleteAddressRepos(id);
	}


}
