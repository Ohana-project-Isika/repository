package fr.isika.cda11.ohana.project.crowdfunding.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.crowdfunding.models.Funding;
import fr.isika.cda11.ohana.project.crowdfunding.repository.FundingRepository;


@Stateless
public class FundingService {
	
	@Inject
	private FundingRepository fundingRepos;
	
	
	public void createFundingService(Funding funding) {

		fundingRepos.createFundingRepos(funding);

	}
	
	public void updateFundingService(Funding funding) {
		
		fundingRepos.updateFundingRepos(funding);
		
	}
	
	public void deleteFundingService(Funding funding) {
		
		fundingRepos.deleteFundingRepos(funding);
		
	}
	
	public Funding findFundingService(Integer id) {
		
		return fundingRepos.findFundingRepos(id);
		
	}
	
	public List<Funding> findListFundingsService() {
		
		return fundingRepos.findFundingsRepos();
		
	}
}
