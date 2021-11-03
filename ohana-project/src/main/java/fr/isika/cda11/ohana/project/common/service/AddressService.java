package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.repository.AddressRepos;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Stateless
public class AddressService {

    @Inject
    private AddressRepos addressRepos;

    public void createAddressService(Address address) {

        addressRepos.createAddressRepos(address);
    }
}
