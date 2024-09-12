package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ContactDto implements Serializable{
	//ATTRIBUTS

	/**
	 * 
	 */
	private static final long serialVersionUID = -6200038750177609749L;
	private Long idContact;
	private String phoneNb;
	private String phoneNb2; 
	private String email;


	//CONSTRUCTOR
	public ContactDto( ) {}


	public Long getIdContact() {
		return idContact;
	}


	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}


	public String getPhoneNb() {
		return phoneNb;
	}


	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;
	}


	public String getPhoneNb2() {
		return phoneNb2;
	}


	public void setPhoneNb2(String phoneNb2) {
		this.phoneNb2 = phoneNb2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idContact == null) ? 0 : idContact.hashCode());
		result = prime * result + ((phoneNb == null) ? 0 : phoneNb.hashCode());
		result = prime * result + ((phoneNb2 == null) ? 0 : phoneNb2.hashCode());
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
		ContactDto other = (ContactDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idContact == null) {
			if (other.idContact != null)
				return false;
		} else if (!idContact.equals(other.idContact))
			return false;
		if (phoneNb == null) {
			if (other.phoneNb != null)
				return false;
		} else if (!phoneNb.equals(other.phoneNb))
			return false;
		if (phoneNb2 == null) {
			if (other.phoneNb2 != null)
				return false;
		} else if (!phoneNb2.equals(other.phoneNb2))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ContactDto [idContact=" + idContact + ", phoneNb=" + phoneNb + ", phoneNb2=" + phoneNb2 + ", email="
				+ email + "]";
	}
	
	
}
