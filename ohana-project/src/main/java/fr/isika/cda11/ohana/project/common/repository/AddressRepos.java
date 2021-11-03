package fr.isika.cda11.ohana.project.common.repository;

import fr.isika.cda11.ohana.project.common.models.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Stateless
public class AddressRepos {

    @PersistenceContext
    private EntityManager entityManager;

    public void createAddressRepos(Address address) {
        entityManager.persist(address);
    }
}
