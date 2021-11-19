package fr.isika.cda11.ohana.project.event.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import fr.isika.cda11.ohana.project.common.models.Order;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class EventController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 435753971102504589L;

	@Inject
    private EventService eventService;

    private List<Event> events;
    private Event event;
    private Event defaultEvent;
    
    private Order cart = new Order();

    private String region;
    private UIComponent component;
    private Map<Event, Integer> numberMap = new HashMap<>();

    @PostConstruct
    public void init() {
        events = eventService.findAllEvents();
        eventService.displayNoEventMsg(events, component);
        numberMap = eventService.computeNumber(events, numberMap);
    }

    public void addEvent() {
        eventService.save(event);
    }

    public String update() {
        events = eventService.findAllEventsByRegion(region);
        numberMap = eventService.computeNumber(events, numberMap);
        return "ticketing?faces-redirect=true";
    }

    public String checkout(Event event) {
        cart.addTicket(event.getTicket());
        return "ticketing/checkout?faces-redirect=true";
    }

//    public Integer getQuantityForTicket(Ticket ticket) {
//    	return cart.getQuantityForTicket(ticket);
//    }
    
    public String decrement(Ticket ticket) {
        cart.decrement(ticket);
        return "";
    }

    public String increment(Ticket ticket) {
       cart.increment(ticket);
        return "";
    }

    public String detail(Event event) {
        this.event = event;
        return "ticketing/detail.xhtml?faces-redirect=true";
    }

    public String back() {
        events = eventService.findAllEvents();
        return "ticketing";
    }

    public String delete(Ticket ticket) {
        cart.removeTicket(ticket);
        return "ticketing/checkout?faces-redirect=true";
    }

}
