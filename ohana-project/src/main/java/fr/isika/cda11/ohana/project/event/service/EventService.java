package fr.isika.cda11.ohana.project.event.service;

import static fr.isika.cda11.ohana.project.event.models.TVA.CORSE;
import static fr.isika.cda11.ohana.project.event.models.TVA.DOM;
import static fr.isika.cda11.ohana.project.event.models.TVA.METROPOLITAN;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Address;
import fr.isika.cda11.ohana.project.common.models.Cart;
import fr.isika.cda11.ohana.project.common.models.Region;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.RATE_TYPE;
import fr.isika.cda11.ohana.project.event.models.TVA;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.repository.EventRepository;

@Stateless
public class EventService implements Serializable {

	private static final long serialVersionUID = -2395116975169375108L;
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
		List<Event> events = eventRepository.findAllEvents();
		manageEvents(events);
		return events;
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

	public List<Event> findAllEventsByRegion(String region) {
		List<Event> events = eventRepository.findAllEvents();
		List<Event> regionalEvents = new ArrayList<>();

		switch (Enum.valueOf(Region.class, region)) {
		case CORSE:
			regionalEvents = getRegionalEvents(events, Region.CORSE);
			break;
		case CVDL:
			regionalEvents = getRegionalEvents(events, Region.CVDL);
			break;
		case BRETAGNE:
			regionalEvents = getRegionalEvents(events, Region.BRETAGNE);
			break;
		case BFC:
			regionalEvents = getRegionalEvents(events, Region.BFC);
			break;
		case GE:
			regionalEvents = getRegionalEvents(events, Region.GE);
			break;
		case OCCITANIE:
			regionalEvents = getRegionalEvents(events, Region.OCCITANIE);
			break;
		case HDF:
			regionalEvents = getRegionalEvents(events, Region.HDF);
			break;
		case ARA:
			regionalEvents = getRegionalEvents(events, Region.ARA);
			break;
		case NORMANDIE:
			regionalEvents = getRegionalEvents(events, Region.NORMANDIE);
			break;
		case PDLL:
			regionalEvents = getRegionalEvents(events, Region.PDLL);
			break;
		case PACA:
			regionalEvents = getRegionalEvents(events, Region.PACA);
			break;
		case NA:
			regionalEvents = getRegionalEvents(events, Region.NA);
			break;
		case GUYANE:
			regionalEvents = getRegionalEvents(events, Region.GUYANE);
			break;
		case MARTINIQUE:
			regionalEvents = getRegionalEvents(events, Region.MARTINIQUE);
			break;
		case MAYOTTE:
			regionalEvents = getRegionalEvents(events, Region.MAYOTTE);
			break;
		case GUADELOUPE:
			regionalEvents = getRegionalEvents(events, Region.GUADELOUPE);
			break;
		case REUNION:
			regionalEvents = getRegionalEvents(events, Region.REUNION);
			break;
		default:
			regionalEvents = getRegionalEvents(events, Region.IDF);
			break;
		}

		manageEvents(regionalEvents);
		return regionalEvents;
	}

	private List<Event> getRegionalEvents(List<Event> events, Region region) {
		List<Event> regionalEvents = new ArrayList<>();

		for (Event event : events) {
			for (String department : region.getDepartments()) {
				if (event.getAddress().getCodePostal().substring(0, 2).equals(department)
						|| event.getAddress().getCodePostal().substring(0, 3).equals(department))
					regionalEvents.add(event);
			}
		}

		return regionalEvents;
	}

	private void manageEvents(List<Event> list) {
		for (Event event : list) {
			event.setTicketQuantity(event.getTickets().size());
			event.setTicket(event.getTickets().get(event.getTickets().size() - 1));

			event.getTicket().setTvaRate(setTVAFor(event.getTicket().getRateType(), event.getTicket().getAppliedTVA())
					.multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_UP));

			event.getTicket().setPostTaxPrice(event.getTicket().getPreTaxPrice()
					.multiply(BigDecimal.valueOf(1).add(event.getTicket().getTvaRate().divide(BigDecimal.valueOf(100))))
					.setScale(2, BigDecimal.ROUND_UP));

			event.setFullAddress(setFullAddress(event.getAddress()));
		}
	}

	private String setFullAddress(Address address) {
		return String.format("%s %s %s %s %s %s", address.getNumRue(), address.getRue(), address.getCodePostal(),address.getVille());
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

	public void create(Event event) {
		eventRepository.createEvent(event);
	}

	public void remove(Long id) {
		eventRepository.removeEvent(id);
	}

	public List<Event> findAll() {
		return eventRepository.findAssociationEvents();
	}

}
