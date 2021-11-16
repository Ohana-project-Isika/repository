package fr.isika.cda11.ohana.project.membership.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Association;
import fr.isika.cda11.ohana.project.membership.models.Membership;
import fr.isika.cda11.ohana.project.membership.repository.MembershipRepos;

@Stateless
public class MembershipService {

	@Inject
	private MembershipRepos membershiprepos;

	public Membership createMembership(String name, Association association) {

		Membership membership = new Membership();
		membership.setName(name);
		membership.setAssociation(association);
		return membership;

	}
}
