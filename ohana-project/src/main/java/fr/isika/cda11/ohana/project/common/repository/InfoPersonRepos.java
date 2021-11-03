package fr.isika.cda11.ohana.project.common.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Stateless
public class InfoPersonRepos {

    @PersistenceContext
    private EntityManager entityManager;
}
