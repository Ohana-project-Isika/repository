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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.common.models.PrivatePerson;

@Entity
public class Funder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 535567564307782064L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private PrivatePerson privateperson;
	
	@OneToMany(mappedBy = "funder", fetch = FetchType.EAGER)
	private List<Funding> fundings = new ArrayList<Funding>();
	
	public void addFunding(Funding funding) {
		this.fundings.add(funding);
	}
	
	public Funder() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrivatePerson getPrivateperson() {
		return privateperson;
	}

	public void setPrivateperson(PrivatePerson privateperson) {
		this.privateperson = privateperson;
	}

	public List<Funding> getFundings() {
		return fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fundings == null) ? 0 : fundings.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((privateperson == null) ? 0 : privateperson.hashCode());
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
		Funder other = (Funder) obj;
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
		if (privateperson == null) {
			if (other.privateperson != null)
				return false;
		} else if (!privateperson.equals(other.privateperson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funder [id=" + id + ", privateperson=" + privateperson + ", fundings=" + fundings + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	
}
