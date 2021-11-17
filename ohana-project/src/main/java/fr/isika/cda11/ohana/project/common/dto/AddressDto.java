package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;

public class AddressDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2480319983004022612L;
	private long id;
	private Integer number;
	private String street;
	private String department;
	private String city;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public AddressDto() {
		
	}
	
	
	
}
