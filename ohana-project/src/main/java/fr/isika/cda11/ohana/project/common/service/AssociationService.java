package fr.isika.cda11.ohana.project.common.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Association;
import fr.isika.cda11.ohana.project.common.repository.AssociationRepos;

@Stateless
public class AssociationService {
	@Inject
	private AssociationRepos associationRepos;

	public void createAssociationService(Association association) {
		associationRepos.createAssociationRepos(association);
	}

	public Association findAssociatin(long id) {
		return associationRepos.findAssociationRepos(id);
	}



}
