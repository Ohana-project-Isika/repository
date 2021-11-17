package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.*;

@Entity
public class Association {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "association_name")
	private String name;
	
	@OneToOne
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public Association(String name, Address address) {
		
		this.name = name;
		this.address = address;
	}
	
	public Association() {

	}
	@Override
	public String toString() {
		return "Association [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
