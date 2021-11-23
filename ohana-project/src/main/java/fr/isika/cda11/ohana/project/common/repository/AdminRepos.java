package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.AdminDto;

import fr.isika.cda11.ohana.project.common.factories.AdminFactory;

import fr.isika.cda11.ohana.project.common.models.Admin;


@Stateless
public class AdminRepos {

	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createAdminRepos(AdminDto adminDto) {
		Admin admin = AdminFactory.fromAdminDto(adminDto);
		entityManager.persist(admin);
	}

	//READ
	public AdminDto findAdminByIdRepos(Long id) {

		AdminDto adminDto= AdminFactory.fromAdmin(entityManager.find(Admin.class, id));	
		return adminDto;
	}

	public List<AdminDto> listAdminRepos(){
		return this.entityManager.createNamedQuery("admin.findAll", Admin.class).getResultList().stream().map(admin -> AdminFactory.fromAdmin(admin)).collect(Collectors.toList());
	}

	//UPDATE
	public Admin updateAdminRepos(AdminDto adminToUpdate) {
		Admin admin = AdminFactory.fromAdminDto(adminToUpdate);
		return entityManager.merge(admin);
	}
	
	//DELETE
	
	public void deleteAdminRepos(Long id) {
		Admin admin = entityManager.find(Admin.class, id);
		if(admin != null) {
			entityManager.remove(admin);
		}
	}
	
}
