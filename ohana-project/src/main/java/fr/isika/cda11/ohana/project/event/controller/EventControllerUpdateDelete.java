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
public class EventControllerUpdateDelete implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    // Utilisé pour le formulaire de modification d'évènement
    private List<Event> events;

    private Event event = new Event();

    @Inject
    private EventService eventService;

    @PostConstruct
    private void init() {
        events = eventService.findAll();
    }

    public void updateEvent() {
        events.forEach(eventService::update);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public void removeEvent(Event event) {
        eventService.remove(event.getId());
        events.remove(event);
    }

}
