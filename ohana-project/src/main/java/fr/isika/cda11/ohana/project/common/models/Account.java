package fr.isika.cda11.ohana.project.common.models;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAccount;
	private String accountLogin;
	private String accountPassword;
	private LocalDate accountCreationDate;
	
	// Relation : OneToOne avec PersonInfo 
	@OneToOne(cascade = CascadeType.ALL)
	private PersonInfo personInfo;
	@OneToOne
	private Role role;

	//Constructeur 
	public Account() {}

	//Getter et setter

	public String getAccountLogin() {return accountLogin;}
	public void setAccountLogin(String accountLogin) {this.accountLogin = accountLogin;}

	public String getAccountPassword() {return accountPassword;	}
	public void setAccountPassword(String accountPassword) {this.accountPassword = accountPassword;}

	public LocalDate getAccountCreationDate() {	return accountCreationDate;}
	public void setAccountCreationDate(LocalDate accountCreationDate) {	this.accountCreationDate = accountCreationDate;}

	public PersonInfo getPersonInfo() {	return personInfo;}
	public void setPersonInfo(PersonInfo personInfo) {this.personInfo = personInfo;}


	public Role getRole() {		return role;	}
	public void setRole(Role role) {this.role = role;	}

	public Long getIdAccount() {return idAccount;}
	public void setIdAccount(Long idAccount) {this.idAccount = idAccount;}

	

	//Hash and Equals
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountCreationDate == null) ? 0 : accountCreationDate.hashCode());
		result = prime * result + ((accountLogin == null) ? 0 : accountLogin.hashCode());
		result = prime * result + ((accountPassword == null) ? 0 : accountPassword.hashCode());
		result = prime * result + ((idAccount == null) ? 0 : idAccount.hashCode());
		result = prime * result + ((personInfo == null) ? 0 : personInfo.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Account other = (Account) obj;
		if (accountCreationDate == null) {
			if (other.accountCreationDate != null)
				return false;
		} else if (!accountCreationDate.equals(other.accountCreationDate))
			return false;
		if (accountLogin == null) {
			if (other.accountLogin != null)
				return false;
		} else if (!accountLogin.equals(other.accountLogin))
			return false;
		if (accountPassword == null) {
			if (other.accountPassword != null)
				return false;
		} else if (!accountPassword.equals(other.accountPassword))
			return false;
		if (idAccount == null) {
			if (other.idAccount != null)
				return false;
		} else if (!idAccount.equals(other.idAccount))
			return false;
		if (personInfo == null) {
			if (other.personInfo != null)
				return false;
		} else if (!personInfo.equals(other.personInfo))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [idAccount=");
		builder.append(idAccount);
		builder.append(", accountLogin=");
		builder.append(accountLogin);
		builder.append(", accountPassword=");
		builder.append(accountPassword);
		builder.append(", accountCreationDate=");
		builder.append(accountCreationDate);
		builder.append(", personInfo=");
		builder.append(personInfo);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
	
	// corps de la méthode de uml 
	public void connect(Long idAcccount, String accountLogin, String accountPassword, LocalDate accountCreationDate, Long idAccount) {
		this.idAccount = idAccount;
		this.accountLogin = accountLogin;
		this.accountPassword = accountPassword;
		this.accountLogin = accountLogin;
		this.accountLogin = accountLogin;
	}
}
