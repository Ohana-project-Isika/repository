package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.common.models.Order;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class EventController implements Serializable {

    @Inject
    private EventService eventService;

    private List<Event> events;
    private Order cart = new Order();
    private Event event;
    private Event defaultEvent;
    private BigDecimal subTotal;
    private BigDecimal total;
    private Map<Ticket, Integer> ticketQuantity = new HashMap<>();
    private int quantity;
    private double hiddenTotal;
    private String region;
    private UIComponent component;
    private Map<Event, Integer> countMap = new HashMap<>();
    private Map<Event, Integer> numberMap = new HashMap<>();

    @PostConstruct
    public void init() {
        events = eventService.findAllEvents();
        eventService.displayNoEventMsg(events, component);
        numberMap = eventService.computeNumber(events, numberMap);
        countMap = eventService.computeCountDefault(events);
    }

    public void addEvent() {
        eventService.save(event);
    }

    public String update() {
        events = eventService.findAllEventsByRegion(region);
        return "ticketing?faces-redirect=true";
    }

    public String checkout(Event event) {
        cart = eventService.addEvents(event, cart);
        return "ticketing/checkout?faces-redirect=true";
    }

    public String decrement(Event event) {
        if (countMap.get(event) <= 0)
            countMap.put(event, 1);

        if (countMap.get(event) > 1 && countMap.get(event) <= event.getTicketQuantity()) {
            countMap.put(event, countMap.get(event) - 1);
//            this.event = eventService.changeTicketPrice(event, count);
        }

        cart = eventService.computeCart(cart, countMap);
//        cart.subtractSubTotal(event, event.getTicket().getPreTaxPrice());
//        cart.subtractTotal(event, event.getTicket().getPostTaxPrice());

        return "ticketing/checkout?faces-redirect=true";
    }

    public String increment(Event event) {
        if (countMap.get(event) >= event.getTicketQuantity())
            countMap.put(event, event.getTicketQuantity());

        if (countMap.get(event) >= 1 && countMap.get(event) < event.getTicketQuantity()) {
            countMap.put(event, countMap.get(event) + 1);
//            this.event = eventService.changeTicketPrice(event, count);
//            cart.addSubTotal(event, event.getTicket().getPreTaxPrice());
//            cart.addTotal(event, event.getTicket().getPostTaxPrice());
        }

        cart = eventService.computeCart(cart, countMap);

        return "ticketing/checkout?faces-redirect=true";
    }

    public String detail(Event event) {
        this.event = event;
        return "ticketing/detail.xhtml?faces-redirect=true";
    }

    public String back() {
        events = eventService.findAllEvents();
        return "ticketing?faces-redirect=true";
    }

    public String delete(Event event) {
        cart.getEvents().remove(event);
        return "ticketing/checkout?faces-redirect=true";
    }
}
