package fr.isika.cda11.ohana.project.membership.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.crowdfunding.models.Association;

@Entity
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@OneToOne
	private Association association;

	public Membership() {

	}

	public Membership(String name, Association association) {
		super();
		this.name = name;
		this.association = association;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public long getId() {
		return id;
	}

}