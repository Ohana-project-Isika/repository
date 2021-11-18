package fr.isika.cda11.ohana.project.crowdfunding.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private String address;
	private String email;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "funder", fetch = FetchType.EAGER)
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


	public Funder() {
		
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getId() {
		return id;
	}
	
}
