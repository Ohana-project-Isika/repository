package fr.isika.cda11.ohana.project.common.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Role {
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private EnumRole role;
	
	//Relations 
	@OneToOne
	private Account account;

	//Constructeur
	public Role() {}


	
	// Getter and setter
	

	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}
	
	

	public EnumRole getRole() {
		return role;
	}



	public void setRole(EnumRole role) {
		this.role = role;
	}



	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}



	public Long getIdRole() {return idRole;	}


	// Hash&equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
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
		Role other = (Role) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		return true;
	}


	//String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [idRole=");
		builder.append(idRole);
		builder.append(", type=");

		builder.append(", account=");
		builder.append(account);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
