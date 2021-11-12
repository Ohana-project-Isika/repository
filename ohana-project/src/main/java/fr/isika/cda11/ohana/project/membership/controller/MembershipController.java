package fr.isika.cda11.ohana.project.membership.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.membership.service.MemberService;
import fr.isika.cda11.ohana.project.membership.service.MembershipService;

@ManagedBean
public class MembershipController {

	@Inject
	private MemberService memberService;
	
	@Inject
	private MembershipService memberShipService;
	
	public void createMembership() {
		
	}
}
