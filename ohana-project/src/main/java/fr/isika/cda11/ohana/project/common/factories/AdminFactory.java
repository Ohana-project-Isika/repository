package fr.isika.cda11.ohana.project.common.factories;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AdminDto;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.Admin;

public class AdminFactory {

	private AdminFactory() {
		
	}

	
	public static Admin fromAdminDto(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setAccount(AccountFactory.fromAccountDto(adminDto.getAccount()));
		admin.setIdAdmin(adminDto.getIdAdmin());

		return admin;
	}
	
	public static AdminDto fromAdmin(Admin admin) {
		AdminDto adminDto = new AdminDto();
		adminDto.setAccount(AccountFactory.fromAccount(admin.getAccount()));
		adminDto.setIdAdmin(admin.getIdAdmin());
		return adminDto;
	}
}
