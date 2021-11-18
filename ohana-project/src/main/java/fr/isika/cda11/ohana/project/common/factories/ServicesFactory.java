package fr.isika.cda11.ohana.project.common.factories;


import fr.isika.cda11.ohana.project.common.dto.ServicesDto;

import fr.isika.cda11.ohana.project.common.models.Services;

public class ServicesFactory {
	private ServicesFactory() {
		
	}

	
	public static Services fromServicesDto(ServicesDto servicesDto) {
		Services services = new Services();
		services.setTypeOfSub(servicesDto.getTypeOfSub());
		services.setPriceOfSub(servicesDto.getPriceOfSub());
		services.setIdServices(servicesDto.getIdServices());

		return services;
	}
	
	public static ServicesDto fromServices(Services services) {
		ServicesDto servicesDto = new ServicesDto();
		servicesDto.setTypeOfSub(services.getTypeOfSub());
		servicesDto.setPriceOfSub(services.getPriceOfSub());
		servicesDto.setIdServices(services.getIdServices());

		return servicesDto;
	}
}
