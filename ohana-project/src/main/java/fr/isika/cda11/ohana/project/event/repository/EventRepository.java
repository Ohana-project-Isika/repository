package fr.isika.cda11.ohana.project.event.repository;

import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Event> findAll() {
        // @formatter:off
        return this.entityManager.createNamedQuery("Events.findAll", Event.class)
                .getResultList()
                .stream()
                .collect(Collectors.toSet());
    }
}
