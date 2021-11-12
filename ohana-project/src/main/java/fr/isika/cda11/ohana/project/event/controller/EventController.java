package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class EventController implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    // Utilisé pour le formulaire de création d'évènement
    private List<Event> events;

    private Event event = new Event();

    @Inject
    private EventService eventService;

    @PostConstruct
    private void init() {
        events = eventService.findAll();
    }

    public void addEvent() {
        eventService.create(event);
        this.events = eventService.findAll();
        this.event = new Event();
    }

    public void updateEvent() {
        events.forEach(eventService::update);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public void onTabChange(Event event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabClose(Event event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }





}
