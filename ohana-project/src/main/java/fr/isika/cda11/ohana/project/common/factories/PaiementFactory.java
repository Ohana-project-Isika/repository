package fr.isika.cda11.ohana.project.common.factories;


import fr.isika.cda11.ohana.project.common.dto.PaiementDto;
import fr.isika.cda11.ohana.project.common.models.Paiement;

public class PaiementFactory {

	private PaiementFactory() {
		
	}

	
	public static Paiement fromPaiementDto(PaiementDto paiementDto) {
		Paiement paiement = new Paiement();
		
		paiement.setPaymentRef(paiementDto.getPaymentRef());
		paiement.setValidated(paiementDto.getValidated());
		paiement.setPaymentDate(paiementDto.getPaymentDate());
		paiement.setAccount(AccountFactory.fromAccountDto(paiementDto.getAccount()));
		paiement.setIdPayment(paiementDto.getIdPayment());

		return paiement;
	}
	
	public static PaiementDto fromPaiement(Paiement paiement) {
		PaiementDto paiementDto = new PaiementDto();
		paiementDto.setPaymentRef(paiement.getPaymentRef());
		paiementDto.setValidated(paiement.getValidated());
		paiementDto.setPaymentDate(paiement.getPaymentDate());
		paiementDto.setAccount(AccountFactory.fromAccount(paiement.getAccount()));
		paiementDto.setIdPayment(paiement.getIdPayment());

		return paiementDto;
	}
}
