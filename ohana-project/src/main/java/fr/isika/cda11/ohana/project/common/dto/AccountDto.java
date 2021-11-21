package fr.isika.cda11.ohana.project.common.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import fr.isika.cda11.ohana.project.enumclass.EnumRole;
import fr.isika.cda11.ohana.project.membership.models.Member;

public class AccountDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4204945251930001319L;
	//ATTRIBUTS

		private Long idAccount;
		private String accountLogin;
		private String accountPassword;
		private EnumRole role;
		private Date accountCreationDate;
		
		// RELATIONS
		private InfoPersonDto infoPerson;

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

		public EnumRole getRole() {
			return role;
		}

		public void setRole(EnumRole role) {
			this.role = role;
		}

		public Date getAccountCreationDate() {
			return accountCreationDate;
		}

		public void setAccountCreationDate(Date accountCreationDate) {
			this.accountCreationDate = accountCreationDate;
		}

		public InfoPersonDto getInfoPerson() {
			return infoPerson;
		}

		public void setInfoPerson(InfoPersonDto infoPerson) {
			this.infoPerson = infoPerson;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

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
			AccountDto other = (AccountDto) obj;
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

		@Override
		public String toString() {
			return "AccountDto [idAccount=" + idAccount + ", accountLogin=" + accountLogin + ", accountPassword="
					+ accountPassword + ", role=" + role + ", accountCreationDate=" + accountCreationDate
					+ ", infoPerson=" + infoPerson + "]";
		}

		
		
}
