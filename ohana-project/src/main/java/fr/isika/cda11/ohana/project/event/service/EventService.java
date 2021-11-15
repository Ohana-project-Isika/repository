package fr.isika.cda11.ohana.project.event.service;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Cart;
import fr.isika.cda11.ohana.project.common.models.Region;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.RATE_TYPE;
import fr.isika.cda11.ohana.project.event.models.TVA;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.*;

import static fr.isika.cda11.ohana.project.event.models.TVA.*;

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


    public List<Event> findAllEvents() {
        List<Event> list = eventRepository.findAllEvents();
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

    public BigDecimal computePreTaxTotal(List<Event> eventsCheckedOut) {
        BigDecimal total = BigDecimal.ZERO;
        for (Event event : eventsCheckedOut)
            total.add(event.getTicket().getPreTaxPrice());

        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal computePostTaxTotal(List<Event> eventsCheckedOut) {
        BigDecimal total = BigDecimal.ZERO;
        for (Event event : eventsCheckedOut)
            total.add(event.getTicket().getPostTaxPrice());

        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public List<Event> findByRegion(String region) {
        switch (Enum.valueOf(Region.class, region)) {
            case CORSE:
                return eventRepository.findAllEventsCORSE();
            case CVDL:
                return eventRepository.findAllEventsCVDL();
            case BRETAGNE:
                return eventRepository.findAllEventsBRETAGNE();
            case BFC:
                return eventRepository.findAllEventsBFC();
            case GE:
                return eventRepository.findAllEventsGE();
            case OCCITANIE:
                return eventRepository.findAllEventsOCCITANIE();
            case HDF:
                return eventRepository.findAllEventsHDF();
            case ARA:
                return eventRepository.findAllEventsARA();
            case NORMANDIE:
                return eventRepository.findAllEventsNORMANDIE();
            case PDLL:
                return eventRepository.findAllEventsPDLL();
            case PACA:
                return eventRepository.findAllEventsPACA();
            case NA:
                return eventRepository.findAllEventsNA();
            case GUYANE:
                return eventRepository.findAllEventsGUYANE();
            case MARTINIQUE:
                return eventRepository.findAllEventsMARTINIQUE();
            case MAYOTTE:
                return eventRepository.findAllEventsMAYOTTE();
            case GUADELOUPE:
                return eventRepository.findAllEventsGUADELOUPE();
            case REUNION:
                return eventRepository.findAllEventsREUNION();
            default:
                return eventRepository.findAllEventsIDF();
        }
    }

    public BigDecimal computeCartSubTotal(Cart cart) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Event event : cart.getEvents()) {
            sum.add(event.getTicket().getPreTaxPrice());
        }

        return sum.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal computeCartTotal(Cart cart) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Event event : cart.getEvents()) {
            sum.add(event.getTicket().getPostTaxPrice());
        }

        return sum.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Cart addEvents(Event event, Cart cart) {
        if (!cart.getEvents().contains(event)) {
            cart.addEvents(event);
            cart.addSubTotal(event.getTicket().getPreTaxPrice());
            cart.addTotal(event.getTicket().getPostTaxPrice());
        }

        return cart;
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
                address.getNumber(), Optional.of(address.getSuffix().toString().toLowerCase()).orElse(""),
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
