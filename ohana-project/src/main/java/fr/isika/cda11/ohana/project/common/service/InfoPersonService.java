package fr.isika.cda11.ohana.project.common.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.repository.InfoPersonRepos;

@Stateless
public class InfoPersonService {
	
	@Inject
	private InfoPersonRepos infoPersonRepos;

}
