package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.common.models.Cart;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private Cart cart = new Cart();
    private List<Event> eventsIDF;
    private Event event;
    private BigDecimal subTotal;
    private BigDecimal total;
    private Map<Ticket, Integer> ticketQuantity = new HashMap<>();
    private int quantity;
    private double hiddenTotal;
    private String region;

    @PostConstruct
    public void init() {
        events = eventService.findAllEvents();
        System.out.println(events);
        eventsIDF = eventService.findAllEventsIDF();
    }

    public void addEvent() {
        eventService.save(event);
    }

    public String update() {
        events = eventService.findByRegion(region);
        return "ticketing?faces-redirect=true";
    }

    public String checkout(Event event) {
        cart.addEvents(event);
//        subTotal = eventService.computePreTaxTotal(cart.getEvents());
//        total = eventService.computePostTaxTotal(cart.getEvents());
        return "ticketing/checkout?faces-redirect=true";
    }

    public String delete(Event event) {
        cart.getEvents().remove(event);
        return "ticketing/checkout?faces-redirect=true";
    }

    public void pay() {
        System.out.println("ggggggggggggggg" + hiddenTotal);
    }
}
