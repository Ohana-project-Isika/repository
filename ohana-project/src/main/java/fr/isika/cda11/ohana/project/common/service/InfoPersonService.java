package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.repository.InfoPersonRepos;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Stateless
public class InfoPersonService {

    @Inject
    private InfoPersonRepos infoPersonRepos;

}
