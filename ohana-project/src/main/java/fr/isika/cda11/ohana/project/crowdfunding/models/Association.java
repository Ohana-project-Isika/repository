package fr.isika.cda11.ohana.project.crowdfunding.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Association {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String address;
	private String phoneNumber;
	private String email;

	@OneToMany(mappedBy = "association")
	private List<Project> projects;
	
	
	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public Association() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public Long getId() {
		return id;
	}
	
	

}
