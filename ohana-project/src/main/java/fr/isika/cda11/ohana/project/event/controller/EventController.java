package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
    private BigDecimal subTotal;
    private BigDecimal total;
    private Map<Ticket, Integer> ticketQuantity = new HashMap<>();
    private int quantity;
    private double hiddenTotal;
    private String region;
    private UIComponent component;
    private Map<Event, Integer> numberMap = new HashMap<>();
    private Map<Event, Integer> countMap = new HashMap<>();

    @PostConstruct
    public void init() {
        events = eventService.findAllEvents();
        eventService.displayNoEventMsg(events, component);
        numberMap = eventService.computeNumber(events, numberMap);
        countMap = eventService.computeCount(events, countMap);
    }

    public String detail(Event event) {
        this.event = event;
        return "billetterie/details.xhtml?faces-redirect=true";
    }

    public String back() {
        events = eventService.findAllEvents();
        numberMap = eventService.computeNumber(events, numberMap);
        return "billetterie";
    }

    public void addEvent() {
        eventService.save(event);
    }

    public String update() {
        events = eventService.findAllEventsByRegion(region);
        numberMap = eventService.computeNumber(events, numberMap);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage("Il n'y a pas d'évènements dans cette région"));
        return "";
    }

    public String decrement(Ticket ticket) {
        if (ticket.getQuantity() > 1 && ticket.getQuantity() <= ticket.getEvent().getTicketQuantity())
            cart.decrement(ticket);

        return "";
    }

    public String increment(Ticket ticket) {
        if (ticket.getQuantity() >= 1 && ticket.getQuantity() < ticket.getEvent().getTicketQuantity())
            cart.increment(ticket);

        return "";
    }

    public String checkout(Event event) {
        cart.addTicket(event.getTicket());
        return "reservation";
    }

    public String delete(Ticket ticket) {
        cart.removeTicket(ticket);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage("Il n'y a plus d'évènements dans votre panier"));
        return "";
    }
}
