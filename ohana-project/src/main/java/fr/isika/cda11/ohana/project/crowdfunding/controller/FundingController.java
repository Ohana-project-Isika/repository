package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.common.repository.PrivatePersonRepos;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.crowdfunding.models.Funder;
import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.service.FundingService;
import fr.isika.cda11.ohana.project.crowdfunding.service.ProjectService;

@ManagedBean(name = "fundingMB")
@SessionScoped
public class FundingController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7127618206225742574L;

	@Inject
	FundingService fundingService;

	@Inject
	ProjectService projectService;
	
	@Inject
	AccountService accountService;
	
	@Inject
	PrivatePersonRepos privatePersonRepos;
	


	Funding theFunding = new Funding();
	Funder theFunder = new Funder();
	AssociationDto associationDto = new AssociationDto();

	public AssociationDto getAssociationDto() {
		return associationDto;
	}

	public void setAssociationDto(AssociationDto associationDto) {
		this.associationDto = associationDto;
	}

	public Funding getTheFunding() {
		return theFunding;
	}

	public Funder getTheFunder() {
		return theFunder;
	}


	public List<Funding> getFundings() {
		return fundingService.findListFundingsService();
	}





	public Long countFundings(Long id) {
		Project p = projectService.findProjectService(id);
		Long res = p.getFundings().stream().count();
		return res;
	}


	public double getActualsFundingsProject(Long idProject) {
		Project p = projectService.findProjectService(idProject);
		List<Funding> res = p.getFundings();
		int amount = 0;

		for (Funding funding : res)
		{
			amount += funding.getFundingAmount();
		}
		return amount;
	}


	public double getFundingAmountMax(Long idProject, double financialGoal) {
		double amount = getActualsFundingsProject(idProject);
		return financialGoal - amount;
	}


	public String finance(Long id) {

		Project p = projectService.findProjectService(id);
		theFunding.setProject(p);
		p.addFunding(theFunding);
		return "financeProject?faces-redirect=true";
	}

	public boolean Agemin (Date dob) {
		Date today = new Date();
		int age = today.getYear() - dob.getYear();

		if(age >18) {
			return true;
		}
		return false;
	}

	
	public String payer(Long id) {		

		// vérifier que le mt de theFunding ne dépasse pas ce qu'on a récolté
		Account account = new Account();
		AccountDto accountDto = new AccountDto();
		accountDto = accountService.findAccountByIdService(id); 
		account = AccountFactory.fromAccountDto(accountDto);
		Long idProject = theFunding.getProject().getId();
		double financialGoal = theFunding.getProject().getFinancialGoal();
		System.out.println("récolte :  " + financialGoal);

		if(theFunding.getFundingAmount() <= getFundingAmountMax(idProject, financialGoal) && Agemin(account.getInfoPerson().getDateOfBirth())) {

			Funder funder2= new Funder();
			PrivatePersonDto privatePersDto = new PrivatePersonDto();
			PrivatePerson privatePerson = new PrivatePerson();
			List<PrivatePersonDto> list = new ArrayList<PrivatePersonDto> ();
			list = privatePersonRepos.listPrivatePersonRepos();
			
			for(PrivatePersonDto p : list)
			{
				if(p.getAccount().getIdAccount() == accountDto.getIdAccount())
				{
					privatePersDto = p;
				}
			}
			
			privatePerson = PrivatePersonFactory.fromPrivatePersonDto(privatePersDto);
			theFunder.setPrivateperson(privatePerson);
			
			funder2=fundingService.updateFunderService(theFunder, theFunding);
			theFunder=funder2;
			fundingService.updateFundingService(theFunding);
			theFunder = new Funder();
			theFunding = new Funding();
			return "customerProjectList";

		} else if (theFunding.getFundingAmount() > getFundingAmountMax(idProject, financialGoal))
		{

			// afficher un message d'erreur ppur le champ montant
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Montant maximum atteint", 
					"Vous avez atteint le montant maximum de récolte de fonds pour ce projet"));

			// ensuite revenir sur la même page
			return "financeProject";
		}

		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Age minimum requis", 
					"Vous devez être majeur pour participer à ce projet"));

			// ensuite revenir sur la même page
			return "financeProject";

		}
	}
}

