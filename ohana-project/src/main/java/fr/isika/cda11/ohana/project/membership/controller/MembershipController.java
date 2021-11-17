package fr.isika.cda11.ohana.project.membership.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.service.MemberService;
import fr.isika.cda11.ohana.project.membership.service.MemberShipManageService;
import fr.isika.cda11.ohana.project.membership.service.MembershipService;

@ManagedBean
@SessionScoped
public class MembershipController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -47700755510349010L;

	@Inject
	private MemberService memberService;

	@Inject
	private MembershipService memberShipService;

	@Inject
	private AssociationService associationService;

	@Inject 
	private MemberShipManageService membershipManageService;

	//ATTRIBUTS----------------------------------------------------------------------------------------------
	MemberDto member = new MemberDto();
	MembershipDto membership = new MembershipDto();
	AssociationDto association = new AssociationDto();
	MemberShipManageDto mbsm = new MemberShipManageDto();

	//GETTER & SETTER--------------------------------------------------------------------------------------
	public MemberShipManageDto getMbsm() {return mbsm;}
	public void setMbsm(MemberShipManageDto mbsm) {this.mbsm = mbsm;}
	public MemberDto getMember() {return member;}
	public void setMember(MemberDto member) {this.member = member;}
	public MembershipDto getMembership() {return membership;}
	public void setMembership(MembershipDto membership) {this.membership = membership;}
	public AssociationDto getAssociation() {return association;}
	public void setAssociation(AssociationDto association) {this.association = association;}
	public static long getSerialversionuid() {return serialVersionUID;}

	//CRUD-------------------------------------------------------------------------------------------------

	//Create
	public String createMembershipManage(long id) {
		association=associationService.findAssociationByIdService(id);
		if (mbsm.getAssociation().getId()==id) {
			return "createMembershipForm";
		}
		else {
		mbsm=membershipManageService.createMembershipManage(mbsm, association);
		return "createMembershipForm";
		}
	}


	public String createMember(long id) {
		membership=memberShipService.findMembershipByIdService(id);
		member=memberService.createMember(member,membership);
		return "showMember";
	}

	public String createMemberShip(Long id) {
		mbsm = membershipManageService.findMembershipManageByIdService(id);
		membership = memberShipService.createMembership(membership, mbsm);
		return "showMembership";
	}

	//Read
	public MembershipDto findMembershipById(long id) {
		membership= memberShipService.findMembershipByIdService(id);
		return membership;
	}
	public String ShowMembership(long id) {
		membership=findMembershipById(id);
		return "showMembership";
	}
	public List<MembershipDto> listMemberships() {
		return memberShipService.listMembershipsService();
	}

	//Update

	public String updateMembershipForm(Long id) {
		MembershipDto membershipToUpdate =findMembershipById(id);
		return "updateMembershipForm";
	}

	public String updateMembership(MembershipDto membership) {
		membership= memberShipService.updateMembershipService(membership);
		return "showMembership";
	}


	//Delete
	public String deleteMembership(long id) {
		membership= findMembershipById(id);
		if(membership.getMembersDto().isEmpty()!= true) {
			for(MemberDto memberdto : membership.getMembersDto()) {
				memberService.deleteMemberService(memberdto.getId());
			}
		};

		memberShipService.deleteMembershipService(id);
		return "AssociationTable";
	}

	//NAVIGATION--------------------------------------------------------------------------------------



	public String createMemberForm(long id) {	
		membership=memberShipService.findMembershipByIdService(id);
		return "createMemberForm";
	}

}
