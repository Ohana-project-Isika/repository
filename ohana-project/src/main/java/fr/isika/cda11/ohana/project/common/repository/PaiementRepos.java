package fr.isika.cda11.ohana.project.common.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.common.dto.PaiementDto;
import fr.isika.cda11.ohana.project.common.factories.PaiementFactory;
import fr.isika.cda11.ohana.project.common.models.Paiement;

@Stateless
public class PaiementRepos {
	@PersistenceContext
	private EntityManager entityManager;

	//CREATE
	public void createPaiementRepos(PaiementDto paiementDto) {
		Paiement paiement = PaiementFactory.fromPaiementDto(paiementDto);
		entityManager.persist(paiement);
	}

	//READ
	public PaiementDto findPaiementRepos(Long id) {

		PaiementDto paiementDto= PaiementFactory.fromPaiement(entityManager.find(Paiement.class, id));	
		return paiementDto;
	}

	public List<PaiementDto> listPaiementRepos(){
		return this.entityManager.createNamedQuery("paiement.findAll", Paiement.class).getResultList().stream().map(paiement -> PaiementFactory.fromPaiement(paiement)).collect(Collectors.toList());
	}

	//UPDATE
	public Paiement updatePaiementRepos(PaiementDto paiementToUpdate) {
		Paiement paiement = PaiementFactory.fromPaiementDto(paiementToUpdate);
		return entityManager.merge(paiement);
	}

	//DELETE

	public void deletePaiementRepos(Long id) {
		Paiement paiement = entityManager.find(Paiement.class, id);
		if(paiement != null) {
			entityManager.remove(paiement);
		}
	}
}
