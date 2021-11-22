package fr.isika.cda11.ohana.project.event.service;

import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.repository.TicketRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TicketService {

    @Inject
    private TicketRepository ticketRepository;

    public Ticket update(Ticket ticket) {
        return ticketRepository.update(ticket);
    }

}
