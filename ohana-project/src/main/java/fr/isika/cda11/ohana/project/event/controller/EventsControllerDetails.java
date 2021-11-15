package fr.isika.cda11.ohana.project.event.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;

@Named
@SessionScoped
public class EventsControllerDetails implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    private Event event;

    @Inject
    private EventService eventService;

    public String afficherDetails(Long eventId) {
    	event = eventService.findById(eventId);
        return "eventDetails";
    }
    
    public Event getEvent() {
		return event;
	}
    public void setEvent(Event event) {
		this.event = event;
	}
    
}
