package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;

public class AssociationDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030236931266644976L;
	
	private long id;
	private String name;
	private AddressDto address = new AddressDto();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AssociationDto() {
		
	}
	
	
	
	
}
