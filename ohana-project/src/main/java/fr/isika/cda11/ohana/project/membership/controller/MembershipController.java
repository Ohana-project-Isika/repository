package fr.isika.cda11.ohana.project.membership.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
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
	List<MembershipDto> membershiplist = new ArrayList<MembershipDto>();


	
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	//GETTER & SETTER--------------------------------------------------------------------------------------
	public MemberShipManageDto getMbsm() {return mbsm;}
	public void setMbsm(MemberShipManageDto mbsm) {this.mbsm = mbsm;}
	public MemberDto getMember() {return member;}
	public void setMember(MemberDto member) {this.member = member;}
	public MembershipDto getMembership() {return membership;}
	public void setMembership(MembershipDto membership) {this.membership = membership;}
	public AssociationDto getAssociation() {return association;}
	public void setAssociation(AssociationDto association) {this.association = association;}
	public List<MembershipDto> getMembershiplist() {return membershiplist;}
	public void setMembershiplist(List<MembershipDto> membershiplist) {this.membershiplist = membershiplist;}


	//CRUD-------------------------------------------------------------------------------------------------





	//Create
	public String createMembershipManage(Long id) {
		association=associationService.findAssociationByIdService(id);
		if (mbsm.getAssociation().getIdAssos()!=Long.valueOf(id)) {
			mbsm=new MemberShipManageDto();
		mbsm= membershipManageService.createMembershipManage(mbsm, association);
		}
		membership = new MembershipDto();
		return "createMembershipForm";
	}

	public String createMemberShip(Long id) {
		mbsm = membershipManageService.findMembershipManageByIdService(id);
		membership = memberShipService.createMembership(membership, mbsm);
		membershiplist=mbsm.getMemberships();
		return "showMembership";
	}
	
	//Read
	public MembershipDto findMembershipById(Long id) {
		membership= memberShipService.findMembershipByIdService(id);
		return membership;
	}
	public String ShowMembership(Long id) {
		membership=findMembershipById(id);
		return "showMembership";
	}
	public List<MembershipDto> listMemberships() {
		return memberShipService.listMembershipsService();
	}

	//Update

	public String updateMembershipForm(Long id) {
		membership =findMembershipById(id);
		return "updateMembershipForm";
	}

	public String updateMembership(MembershipDto membership) {
		membership= memberShipService.updateMembershipService(membership);
		return "showMembership";
	}


	//Delete
	public String deleteMembership(Long id) {
		membership= findMembershipById(id);
		if(membership.getMembers().isEmpty()!= true) {
			for(MemberDto memberdto : membership.getMembers()) {
				memberService.deleteMemberService(memberdto.getIdMember());
			}
		};

		memberShipService.deleteMembershipService(id);
		mbsm.getMemberships().remove(membership);
		membership=new MembershipDto();
		
		return "AssociationTable";
	}

	//NAVIGATION--------------------------------------------------------------------------------------



	public String createMemberForm(Long id) {	
		membership=memberShipService.findMembershipByIdService(id);
		return "createMemberForm";
	}
	
	public String subMemberForm(Long id) {
		association=associationService.findAssociationByIdService(id);
		List<MemberShipManageDto> mbsmsByAssos = membershipManageService.listMembershipManageService();
		for(MemberShipManageDto mbmdto : mbsmsByAssos) {
			if(mbmdto.getAssociation().getIdAssos() == Long.valueOf(id)) {
				mbsm=mbmdto;
			}
			else {
				mbsm=new MemberShipManageDto();
			}
		}
		
		List<MembershipDto> allMembershipAssos = new ArrayList<MembershipDto>();
		allMembershipAssos = memberShipService.listMembershipsService();
		for(MembershipDto membershdto: allMembershipAssos) {
			if(membershdto.getMemberShipManage().getId()==mbsm.getId()) {
				mbsm.getMemberships().add(membershdto);	
			}
		}
		membershiplist=mbsm.getMemberships();

		return "subMember";
	}
	
	public static void main(String[] args) {
		
	}

}
