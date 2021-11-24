package fr.isika.cda11.ohana.project.event.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cda11.ohana.project.event.service.EventService;

@Named
@ViewScoped
public class EventsControllerDelete implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    @Inject
    private EventService eventService;

    public String supprimer(Long eventId) {
    	eventService.remove(eventId);
    	return "eventsList?faces-redirect=true";
    }
    
}
