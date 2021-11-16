package fr.isika.cda11.ohana.project.event.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda11.ohana.project.event.models.Event;

@Stateless
public class EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void persistEvent(Event event) {
        entityManager.persist(event);
    }

    public Event update(Event event) {
        return entityManager.merge(event);
    }

    public Event findById(Long id) {
        return entityManager.find(Event.class, id);
    }

    //public List<Event> findAllEventsIDF() { return entityManager.createNamedQuery("Events.IDF.findAll").getResultList(); }

    public List<Event> findAllEvents() { return entityManager.createNamedQuery("Events.findAll").getResultList(); }

    public void createEvent(Event event) {
        entityManager.persist(event);
    }

    public Event updateEvent(Event event) {
        entityManager.merge(event);
        return event;
    }

    public Event readEvent(Long id) {
        return entityManager.find(Event.class, id);
    }

    public void removeEvent(Long id) {
        Event managedEvent = entityManager.find(Event.class, id);
        if (managedEvent != null) {
            entityManager.remove(managedEvent);
        }
    }

    public List<Event> findAssociationEvents() {
        // @formatter:off
        return this.entityManager.createNamedQuery("Events.findAll", Event.class)
                .getResultList();
        // @formatter:on
    }

}
