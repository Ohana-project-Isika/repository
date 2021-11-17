package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAdmin;

	// constructeur
	public Admin() {
	}

	// Relations
	@OneToOne
	private Role role;

	// Getter and setter
	public Role getRole() {	return role;}
	public void setRole(Role role) {this.role = role;	}

	public Long getIdAdmin() {return idAdmin;}

	//Hash and code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAdmin == null) ? 0 : idAdmin.hashCode());
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
		Admin other = (Admin) obj;
		if (idAdmin == null) {
			if (other.idAdmin != null)
				return false;
		} else if (!idAdmin.equals(other.idAdmin))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	

	//String toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [idAdmin=");
		builder.append(idAdmin);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
}
