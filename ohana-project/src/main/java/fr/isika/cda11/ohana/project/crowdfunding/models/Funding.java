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
	
	
	//private Person person;
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
/*
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	*/

	public Long getId() {
		return id;
	}

}
