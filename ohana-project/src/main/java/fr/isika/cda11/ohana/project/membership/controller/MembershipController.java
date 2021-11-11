package src.main.java.fr.isika.cda11.ohana.project.membership.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class MembershipController {

	@Inject
	private MemberService memberService;
	
	@Inject
	private MembershipService memberShipService;
	
	public void createMembership() {
		
	}
}
