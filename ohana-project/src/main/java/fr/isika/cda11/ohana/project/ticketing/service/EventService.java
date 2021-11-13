package fr.isika.cda11.ohana.project.ticketing.service;

import fr.isika.cda11.ohana.project.common.model.Address;
import fr.isika.cda11.ohana.project.ticketing.models.Event;
import fr.isika.cda11.ohana.project.ticketing.models.RATE_TYPE;
import fr.isika.cda11.ohana.project.ticketing.models.TVA;
import fr.isika.cda11.ohana.project.ticketing.models.Ticket;
import fr.isika.cda11.ohana.project.ticketing.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
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
        manageEvents(list);
        return list;
    }

    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event update(Event event) {
        eventRepository.update(event);
        return findById(event.getId());
    }

    private void manageEvents(List<Event> list) {
        for (Event event : list) {
            event.setTicketQuantity(event.getTickets().size());
            event.setTicket(event.getTickets().get(event.getTickets().size() - 1));
            event.getTicket().setTvaRate(setTVAFor(event.getTicket().getRateType(), event.getTicket().getAppliedTVA())
                    .multiply(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_UP));
            event.getTicket().setPostTaxPrice(event.getTicket().getPreTaxPrice().multiply(BigDecimal.valueOf(1)
                    .add(event.getTicket().getTvaRate().divide(BigDecimal.valueOf(100))))
                    .setScale(2,BigDecimal.ROUND_UP));
            event.setFullAddress(setFullAddress(event.getAddress()));
        }
    }
    private String setFullAddress(Address address) {
        return String.format("%s %s %s %s %s %s",
                address.getNumber(), Optional.ofNullable(address.getSuffix().toString().toLowerCase()).orElse(""),
                address.getStreetName(), Optional.ofNullable(address.getStreetComplement()).orElse(""),
                address.getPostCode(), address.getCity());
    }

    private BigDecimal setTVAFor(RATE_TYPE rateType, TVA tva) {
        switch (rateType) {
            case REDUCED1:
                switch (tva) {
                    case CORSE:
                        return CORSE.getReducedRate1();
                    case DOM:
                        return DOM.getReducedRate1();
                    default:
                        return METROPOLITAN.getReducedRate1();
                }
            case REDUCED2:
                switch (tva) {
                    case CORSE:
                        return CORSE.getReducedRate2();
                    case DOM:
                        return DOM.getReducedRate2();
                    default:
                        return METROPOLITAN.getReducedRate2();
                }
            case REGULAR:
                switch (tva) {
                    case CORSE:
                        return CORSE.getRegularRate();
                    case DOM:
                        return DOM.getRegularRate();
                    default:
                        return METROPOLITAN.getRegularRate();
                }
            default:
                switch (tva) {
                    case CORSE:
                        return CORSE.getSuperReducedRate();
                    case DOM:
                        return DOM.getSuperReducedRate();
                    default:
                        return METROPOLITAN.getSuperReducedRate();
                }
        }
    }
}
