package fr.isika.cda11.ohana.project.crowdfunding.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.isika.cda11.ohana.project.common.models.Association;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double financialGoal;
	
	private Date startDate;
	
	private Date endDate;
	
	private String description;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private List<Funding> fundings = new ArrayList<Funding>();
	
	@ManyToOne
	@JoinColumn(name="ASSOCIATION_ID")
	private Association association;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
