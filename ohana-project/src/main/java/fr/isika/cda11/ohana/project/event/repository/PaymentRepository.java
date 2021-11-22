package fr.isika.cda11.ohana.project.event.repository;

import fr.isika.cda11.ohana.project.event.models.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Order order) {
        entityManager.persist(order);
    }
}
