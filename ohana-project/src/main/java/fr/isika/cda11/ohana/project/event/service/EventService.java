package fr.isika.cda11.ohana.project.event.service;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EventService {

    @Inject
    private EventRepository eventRepository;

    public void create(Event event) {eventRepository.createEvent(event);}

    public void remove(Long id) {
        eventRepository.removeEvent(id);
    }

    public Event update(Event event) {eventRepository.updateEvent(event); return event;}

    public List<Event> findAll() {return eventRepository.findAssociationEvents();}

    public Event findById(Long objectId) {return eventRepository.readEvent(objectId);}
}
