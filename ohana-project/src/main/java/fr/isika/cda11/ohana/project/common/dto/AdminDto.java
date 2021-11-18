package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;


public class AdminDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3736959729953828420L;

	private Long idAdmin;
	
	// RELATIONS

	private AccountDto account;

	//CONSTRUCTOR
	public AdminDto() {
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
		AdminDto other = (AdminDto) obj;
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

	@Override
	public String toString() {
		return "AdminDto [idAdmin=" + idAdmin + ", account=" + account + "]";
	}

}
