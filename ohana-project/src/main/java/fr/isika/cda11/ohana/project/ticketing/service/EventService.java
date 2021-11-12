package fr.isika.cda11.ohana.project.ticketing.service;

import fr.isika.cda11.ohana.project.ticketing.models.Event;
import fr.isika.cda11.ohana.project.ticketing.models.RATE_TYPE;
import fr.isika.cda11.ohana.project.ticketing.models.TVA;
import fr.isika.cda11.ohana.project.ticketing.models.Ticket;
import fr.isika.cda11.ohana.project.ticketing.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;

import static fr.isika.cda11.ohana.project.ticketing.models.TVA.*;
import static fr.isika.cda11.ohana.project.ticketing.models.TVA.CORSE;

@Stateless
public class EventService {

    @Inject
    private EventRepository eventRepository;

    public void save(Event event) {
        for (int i = 0; i < event.getTicketQuantity(); i++) {
            Ticket ticket = new Ticket();
            ticket.setEvent(event);
            event.getTickets().add(ticket);
            eventRepository.persistEvent(event);
        }
    }

    public List<Event> findAllEventsIDF() {
        List<Event> list = eventRepository.findAllEventsIDF();

        for (Event event : list) {
            event.setTicketQuantity(event.getTickets().size());
            event.setTicket(event.getTickets().get(event.getTickets().size() - 1));
            setTVAFor(event, event.getTicket().getRateType(), event.getTicket().getAppliedTVA());
        }

        return list;
    }

    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event update(Event event) {
        eventRepository.update(event);
        return findById(event.getId());
    }

    private void setTVAFor(Event event, RATE_TYPE rateType, TVA tva) {
        switch (rateType) {
            case REDUCED1:
                switch (tva) {
                    case CORSE:
                        event.getTicket().setTvaRate(CORSE.getReducedRate1());
                        break;
                    case DOM:
                        event.getTicket().setTvaRate(DOM.getReducedRate1());
                        break;
                    default:
                        event.getTicket().setTvaRate(METROPOLITAN.getReducedRate1());
                        break;
                }
                break;
            case REDUCED2:
                switch (tva) {
                    case CORSE:
                        event.getTicket().setTvaRate(CORSE.getReducedRate2());
                        break;
                    case DOM:
                        event.getTicket().setTvaRate(DOM.getReducedRate2());
                        break;
                    default:
                        event.getTicket().setTvaRate(METROPOLITAN.getReducedRate2());
                        break;
                }
                break;
            case REGULAR:
                switch (tva) {
                    case CORSE:
                        event.getTicket().setTvaRate(CORSE.getRegularRate());
                        break;
                    case DOM:
                        event.getTicket().setTvaRate(DOM.getRegularRate());
                        break;
                    default:
                        event.getTicket().setTvaRate(METROPOLITAN.getRegularRate());
                        break;
                }
                break;
            case SUPER_REDUCED:
                break;
            default:
                switch (tva) {
                    case CORSE:
                        event.getTicket().setTvaRate(CORSE.getSuperReducedRate());
                        break;
                    case DOM:
                        event.getTicket().setTvaRate(DOM.getSuperReducedRate());
                        break;
                    default:
                        event.getTicket().setTvaRate(METROPOLITAN.getSuperReducedRate());
                        break;
                }
                break;
        }
    }
}
