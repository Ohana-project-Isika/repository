package fr.isika.cda11.ohana.project.event.repository;

import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

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
        return this.entityManager.createNamedQuery("Event.findAllEvent", Event.class)
                .getResultList();
        // @formatter:on
    }

}
