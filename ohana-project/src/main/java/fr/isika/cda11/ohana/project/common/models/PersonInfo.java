package fr.isika.cda11.ohana.project.common.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PersonInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPersInfo;
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	

	@OneToMany
	private List<Contact> contact;
	
	@OneToMany
	private List<Address> address;
	
	//constructeur vide
	public PersonInfo( ) {}
	
	//getter et setter
	public String getLastName() 			{return lastName;}
	public void setLastName(String lastName){this.lastName = lastName;}

	public String getFirstName() 		{return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public Date getDateOfBirth() 			{return dateOfBirth;}
	public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}

	public long getIdPersInfo() 	{return idPersInfo;}
	
	
	public List<Contact> getContact() {return contact;}
	public void setContact(List<Contact> contact) {this.contact = contact;}

	public List<Address> getAddress() {	return address;}
	public void setAddress(List<Address> address) {	this.address = address;}

	// Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idPersInfo == null) ? 0 : idPersInfo.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		PersonInfo other = (PersonInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idPersInfo == null) {
			if (other.idPersInfo != null)
				return false;
		} else if (!idPersInfo.equals(other.idPersInfo))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	//String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonInfo [idPersInfo=");
		builder.append(idPersInfo);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", contact=");
		builder.append(contact);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
}
