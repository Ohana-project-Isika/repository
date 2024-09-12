package fr.isika.cda11.ohana.project.membership.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AddressDto;
import fr.isika.cda11.ohana.project.common.dto.ContactDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.service.MemberService;
import fr.isika.cda11.ohana.project.membership.service.MembershipService;

@ManagedBean
@SessionScoped
public class MemberController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4078082924745348068L;

	@Inject
	private MemberService memberService;

	@Inject
	private MembershipService memberShipService;
	@Inject
	private AccountService accountService;




	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	ContactDto contactDto = new ContactDto();
	InfoPersonDto infopersonDto = new InfoPersonDto();
	AccountDto accountDto = new AccountDto();
	PrivatePersonDto privatepersonDto= new PrivatePersonDto();
	MemberDto memberDto = new MemberDto();
	MembershipDto membershipDto=new MembershipDto();
	AddressDto adressDto= new AddressDto();

	public ContactDto getContactDto() {return contactDto;}
	public void setContactDto(ContactDto contactDto) {this.contactDto = contactDto;}
	public InfoPersonDto getInfopersonDto() {return infopersonDto;}
	public void setInfopersonDto(InfoPersonDto infopersonDto) {this.infopersonDto = infopersonDto;}
	public AccountDto getAccountDto() {return accountDto;}
	public void setAccountDto(AccountDto accountDto) {this.accountDto = accountDto;}
	public PrivatePersonDto getPrivatepersonDto() {return privatepersonDto;}
	public void setPrivatepersonDto(PrivatePersonDto privatepersonDto) {this.privatepersonDto = privatepersonDto;}
	public MemberDto getMemberDto() {return memberDto;}
	public void setMemberDto(MemberDto memberDto) {this.memberDto = memberDto;}
	public static long getSerialversionuid() {return serialVersionUID;}
	public MembershipDto getMembershipDto() {return membershipDto;}
	public void setMembershipDto(MembershipDto membershipDto) {this.membershipDto = membershipDto;}

	public String createMember(Long id) {
		membershipDto=memberShipService.findMembershipByIdService(id);
		memberDto.setDateOfStart(new Date());
		memberDto=memberService.createMember(memberDto,membershipDto, contactDto, infopersonDto, accountDto, adressDto);
		membershipDto.getMembers().add(memberDto);
		return "showMember";
	}

	public String subMember(Long idMbsh, Long idAccount) {
		membershipDto=memberShipService.findMembershipByIdService(idMbsh);
		accountDto=accountService.findAccountByIdService(idAccount);
		memberDto=memberService.subMember(membershipDto, accountDto);
		membershipDto.getMembers().add(memberDto);
		return "showMember";
	}
	
    public void confirm() {
        addMessage("Confirmed", "You have accepted");
    }

    public void delete() {
        addMessage("Confirmed", "Record deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
