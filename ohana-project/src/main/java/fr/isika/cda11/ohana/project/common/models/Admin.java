package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Admin {
	
	//ATTRIBUTS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;
	
	// RELATIONS
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="ACCOUNT_ID", nullable=false)
	private Account account;

	//CONSTRUCTOR
	public Admin() {
	}

	//GETTER AND SETTER
	public Long getIdAdmin() {return idAdmin;}
	public void setIdAdmin(Long idAdmin) {this.idAdmin = idAdmin;}
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((idAdmin == null) ? 0 : idAdmin.hashCode());
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
		Admin other = (Admin) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (idAdmin == null) {
			if (other.idAdmin != null)
				return false;
		} else if (!idAdmin.equals(other.idAdmin))
			return false;
		return true;
	}

	//METHOD TO STRING
	
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", account=" + account + "]";
	}


	
}
