package fr.isika.cda11.ohana.project.common.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.dto.AdminDto;
import fr.isika.cda11.ohana.project.common.dto.InfoPersonDto;
import fr.isika.cda11.ohana.project.common.repository.AdminRepos;
import fr.isika.cda11.ohana.project.common.repository.InfoPersonRepos;

@Stateless
public class InfoPersonService {
	
	@Inject
	private InfoPersonRepos infoPersonRepos;
	
	//CREATE
	public void createInfoPersonService(InfoPersonDto infoPersonDto) {

		infoPersonRepos.createInfoPersonRepos(infoPersonDto);
	}
	
	//READ
	public InfoPersonDto findInfoPersonByIdService(long id) {
		return infoPersonRepos.findInfoPersonByIdRepos(id);
	}

	public List<InfoPersonDto> listInfoPersonService() {
		return infoPersonRepos.listInfoPersonRepos();
	}
	
	//UPDATE
	public InfoPersonDto updateInfoPersonService(InfoPersonDto infoPersonDto) {
		infoPersonRepos.updateInfoPersonRepos(infoPersonDto);
		return findInfoPersonByIdService(infoPersonDto.getIdInfoPers());
	}

	//DELETE
	public void deleteInfoPersonService(long id) {
		infoPersonRepos.deleteInfoPersonRepos(id);
	}
}
