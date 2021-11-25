package fr.isika.cda11.ohana.project.crowdfunding.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.isika.cda11.ohana.project.common.models.Association;

@Entity
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3003817162804761347L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double financialGoal;
	
	private Date startDate;
	
	private Date endDate;
	
	@Lob
	private String description;
	
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", financialGoal=" + financialGoal + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + ", image=" + image + ", fundings="
				+ fundings + ", association=" + association + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((association == null) ? 0 : association.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(financialGoal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fundings == null) ? 0 : fundings.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (association == null) {
			if (other.association != null)
				return false;
		} else if (!association.equals(other.association))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Double.doubleToLongBits(financialGoal) != Double.doubleToLongBits(other.financialGoal))
			return false;
		if (fundings == null) {
			if (other.fundings != null)
				return false;
		} else if (!fundings.equals(other.fundings))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

}
