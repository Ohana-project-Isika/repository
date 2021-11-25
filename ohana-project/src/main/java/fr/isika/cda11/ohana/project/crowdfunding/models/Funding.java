package fr.isika.cda11.ohana.project.crowdfunding.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funding implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6586939575890695109L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funder == null) ? 0 : funder.hashCode());
		result = prime * result + ((fundingAmount == null) ? 0 : fundingAmount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
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
		Funding other = (Funding) obj;
		if (funder == null) {
			if (other.funder != null)
				return false;
		} else if (!funder.equals(other.funder))
			return false;
		if (fundingAmount == null) {
			if (other.fundingAmount != null)
				return false;
		} else if (!fundingAmount.equals(other.fundingAmount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Funding [id=" + id + ", fundingAmount=" + fundingAmount + ", project=" + project.getId() + ", funder=" + funder.getId()
//				+ "]";
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
