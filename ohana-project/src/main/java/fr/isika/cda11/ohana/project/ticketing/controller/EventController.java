package fr.isika.cda11.ohana.project.ticketing.controller;

import fr.isika.cda11.ohana.project.ticketing.models.Event;
import fr.isika.cda11.ohana.project.ticketing.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class EventController implements Serializable {

    @Inject
//    @Setter(AccessLevel.NONE)
    private EventService eventService;

    private List<Event> events;
    private List<Event> eventsIDF;
    private Event event = new Event();

    @PostConstruct
    public void init() {
        events = eventService.findAllEventsIDF();
        eventsIDF = eventService.findAllEventsIDF();
    }

    public void addEvent() {
        eventService.save(event);
    }

    public void update() {
        events.forEach(eventService::update);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }
}
