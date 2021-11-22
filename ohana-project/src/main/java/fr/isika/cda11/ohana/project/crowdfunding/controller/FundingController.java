package fr.isika.cda11.ohana.project.crowdfunding.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funder;
import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.models.Project;
import fr.isika.cda11.ohana.project.crowdfunding.service.FundingService;
import fr.isika.cda11.ohana.project.crowdfunding.service.ProjectService;

@ManagedBean(name = "fundingMB")
@SessionScoped
public class FundingController {


	@Inject
	FundingService fundingService;

	@Inject
	ProjectService projectService;



	Funding theFunding = new Funding();
	Funder theFunder = new Funder();

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

	public String payer() {		

		// vérifier que le mt de theFunding ne dépasse pas ce qu'on a récolté

		Long idProject = theFunding.getProject().getId();
		double financialGoal = theFunding.getProject().getFinancialGoal();
		System.out.println("récolte :  " + financialGoal);

		if(theFunding.getFundingAmount() <= getFundingAmountMax(idProject, financialGoal) && Agemin(theFunder.getDateOfBirth())) {

			fundingService.updateFundingService(theFunding);
			theFunding = new Funding();
			fundingService.updateFunderService(theFunder);
			theFunder = new Funder();
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

