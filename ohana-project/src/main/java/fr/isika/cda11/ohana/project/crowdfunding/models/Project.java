package fr.isika.cda11.ohana.project.crowdfunding.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private double financialGoal;
	
	private String duration;
	
	private String description;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private List<Funding> fundings = new ArrayList<Funding>();
	
	public void addFunding(Funding funding) {
		this.fundings.add(funding);
	}
	
	public List<Funding> getFundings() {
		return fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	public Project() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFinancialGoal() {
		return financialGoal;
	}

	public void setFinancialGoal(double financialGoal) {
		this.financialGoal = financialGoal;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

}
