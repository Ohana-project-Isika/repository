package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Stateless
public class AssociationService {

    @Inject
    private AssociationRepos associationRepos;

    public void createAssociationService(Association association) {
        associationRepos.createAssociationRepos(association);
    }

}
