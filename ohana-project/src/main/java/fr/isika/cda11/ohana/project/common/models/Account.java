package fr.isika.cda11.ohana.project.common.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "Accounts.findAll", query = "SELECT DISTINCT a FROM Account a")
})
public class Account {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccount;
	private String accountLogin;
	private String accountPassword;
	private LocalDate accountCreationDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<Order> orders = new ArrayList<>();
	
	// Relation : OneToOne avec PersonInfo 
	@OneToOne(cascade = CascadeType.ALL)
	private PersonInfo personInfo;
	@OneToOne
	private Role role;

	//Constructeur 
	public Account() {}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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
		return "Account [idAccount=" + idAccount + ", accountLogin=" + accountLogin + ", accountPassword="
				+ accountPassword + ", accountCreationDate=" + accountCreationDate + ", personInfo=" + personInfo
				+ ", role=" + role + "]";
	}

	

}
