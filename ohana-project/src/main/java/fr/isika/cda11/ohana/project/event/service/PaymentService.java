package fr.isika.cda11.ohana.project.event.service;


import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.repository.PaymentRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PaymentService {

    @Inject
    private PaymentRepository paymentRepository;


    private void log(String string) {
        System.out.println(string);

    }

    public void save(Order order) {
        paymentRepository.save(order);
    }
}
