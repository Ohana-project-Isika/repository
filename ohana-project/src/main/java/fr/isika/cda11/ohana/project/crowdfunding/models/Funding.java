package fr.isika.cda11.ohana.project.crowdfunding.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer fundingAmount;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private Funder funder;
	
	
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public Funding() {
		
	}

	public Integer getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(Integer fundingAmount) {
		this.fundingAmount = fundingAmount;
	}


	public Funder getFunder() {
		return funder;
	}

	public void setFunder(Funder funder) {
		this.funder = funder;
	}

	public Long getId() {
		return id;
	}

}
