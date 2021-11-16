package fr.isika.cda11.ohana.project.event.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;

@Named
@ViewScoped
public class EventsController implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    private List<Event> events;

    @Inject
    private EventService eventService;

    @PostConstruct
    private void init() {
        events = eventService.findAll();
    }

    public List<Event> getEvents() {
		return events;
	}
    public void setEvents(List<Event> events) {
		this.events = events;
	}
}
