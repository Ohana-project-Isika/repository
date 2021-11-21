package fr.isika.cda11.ohana.project.membership.factories;

import fr.isika.cda11.ohana.project.membership.dto.SubscriptionFeeDto;
import fr.isika.cda11.ohana.project.membership.models.SubscriptionFee;

public class SubscriptionFeeFactory {
	
	public static SubscriptionFee fromSubscriptionFeeDto(SubscriptionFeeDto subDto) {
		SubscriptionFee sub = new SubscriptionFee();
		sub.setFeeAmount(subDto.getFeeAmount());
		sub.setDateOfStart(subDto.getDateOfStart());
		sub.setDateOfEnd(subDto.getDateOfEnd());
		sub.setIdSubFee(subDto.getIdSubFee());
		sub.setMembership(subDto.getMembership());
		return sub;
	}
	
	public static SubscriptionFeeDto fromSubscriptionFee(SubscriptionFee sub) {
		SubscriptionFeeDto subDto = new SubscriptionFeeDto();
		subDto.setFeeAmount(sub.getFeeAmount());
		subDto.setDateOfStart(sub.getDateOfStart());
		subDto.setDateOfEnd(sub.getDateOfEnd());
		subDto.setIdSubFee(Long.valueOf(sub.getIdSubFee()));
		subDto.setMembership(sub.getMembership());
		return subDto;
	}

}
