package fr.isika.cda11.ohana.project.event.repository;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.event.models.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //UPDATE
    public Ticket update(Ticket ticket) {
        return entityManager.merge(ticket);
    }
}
