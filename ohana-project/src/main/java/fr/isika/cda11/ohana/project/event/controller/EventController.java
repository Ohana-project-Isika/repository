package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Set;

@Named
@ViewScoped
@Getter
@Setter
public class EventController implements Serializable {

    @Inject
//    @Setter(AccessLevel.NONE)
    private EventService eventService;

    private Set<Event> events;
    private Event event = new Event();

    @PostConstruct
    public void init() {
        this.events = eventService.findAll();
    }

    public void addEvent() {
        eventService.save(event);
    }

    public void update() {
        events.forEach(eventService::update);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }
}
