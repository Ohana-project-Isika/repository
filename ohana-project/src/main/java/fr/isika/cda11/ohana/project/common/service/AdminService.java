package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.inject.Inject;
import fr.isika.cda11.ohana.project.common.dto.AdminDto;
import fr.isika.cda11.ohana.project.common.repository.AdminRepos;

public class AdminService {
	@Inject
	private AdminRepos adminRepos;
	
	//CREATE
	public void createAdminService(AdminDto adminDto) {

		adminRepos.createAdminRepos(adminDto);
	}
	
	//READ
	public AdminDto findAdminByIdService(long id) {
		return adminRepos.findAdminByIdRepos(id);
	}

	public List<AdminDto> listAdminService() {
		return adminRepos.listAdminRepos();
	}
	
	//UPDATE
	public AdminDto updateAdminService(AdminDto adminDto) {
		adminRepos.updateAdminRepos(adminDto);
		return findAdminByIdService(adminDto.getIdAdmin());
	}

	//DELETE
	public void deleteAdminService(long id) {
		adminRepos.deleteAdminRepos(id);
	}
}
