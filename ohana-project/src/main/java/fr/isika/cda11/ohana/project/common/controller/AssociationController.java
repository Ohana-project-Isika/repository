package fr.isika.cda11.ohana.project.common.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.service.AddressService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;

@ManagedBean
public class AssociationController {

    @Inject
    private AddressService addressService;

    @Inject
    private AssociationService associationService;

    public void subscription() {
        Address address = new Address();
        addressService.createAddressService(address);
        Association association = new Association();
        association.setAddress(address);
        associationService.createAssociationService(association);
    }

    public static void main(String[] args) { }

}
