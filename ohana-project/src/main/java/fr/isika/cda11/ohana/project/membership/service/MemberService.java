package fr.isika.cda11.ohana.project.membership.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.membership.repository.MemberRepos;

@Stateless
public class MemberService {

	@Inject
	private MemberRepos memberRepos;
}
