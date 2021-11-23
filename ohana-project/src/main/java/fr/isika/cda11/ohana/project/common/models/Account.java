package fr.isika.cda11.ohana.project.common.models;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import fr.isika.cda11.ohana.project.enumclass.EnumRole;

@Entity
@NamedQueries({
	@NamedQuery(name = "account.findAll", query = "SELECT c FROM Account c")})
public class Account {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccount;
	@Column(nullable=false)
	private String accountLogin;
	private String accountPassword = "00000";
	@Enumerated(EnumType.STRING)
	private EnumRole role;
	private Date accountCreationDate;
	
	// RELATIONS
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="INFOPERSON_ID", nullable=false)
	private InfoPerson infoPerson;

	//CONSTRUCTEUR 
	public Account() {}

	//GETTER AND SETTER
	public Long getIdAccount() {return idAccount;}
	public void setIdAccount(Long idAccount) {this.idAccount = idAccount;}
	public String getAccountLogin() {return accountLogin;}
	public void setAccountLogin(String accountLogin) {this.accountLogin = accountLogin;}
	public String getAccountPassword() {return accountPassword;}
	public void setAccountPassword(String accountPassword) {this.accountPassword = accountPassword;}
	public Date getAccountCreationDate() {return accountCreationDate;}
	public void setAccountCreationDate(Date accountCreationDate) {this.accountCreationDate = accountCreationDate;}
	public InfoPerson getInfoPerson() {return infoPerson;}
	public void setInfoPerson(InfoPerson infoPerson) {this.infoPerson = infoPerson;}
	public EnumRole getRole() {return role;}
	public void setRole(EnumRole role) {this.role = role;}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountCreationDate == null) ? 0 : accountCreationDate.hashCode());
		result = prime * result + ((accountLogin == null) ? 0 : accountLogin.hashCode());
		result = prime * result + ((accountPassword == null) ? 0 : accountPassword.hashCode());
		result = prime * result + ((idAccount == null) ? 0 : idAccount.hashCode());
		result = prime * result + ((infoPerson == null) ? 0 : infoPerson.hashCode());
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
		if (infoPerson == null) {
			if (other.infoPerson != null)
				return false;
		} else if (!infoPerson.equals(other.infoPerson))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	//METHOD TO STRING
	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", accountLogin=" + accountLogin + ", accountPassword="
				+ accountPassword + ", role=" + role + ", accountCreationDate=" + accountCreationDate + ", infoPerson="
				+ infoPerson + "]";
	}

	

}
