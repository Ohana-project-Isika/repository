package fr.isika.cda11.ohana.project.ticketing.repository;

import fr.isika.cda11.ohana.project.ticketing.models.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static fr.isika.cda11.ohana.project.common.model.Constant.SELECT_EVENTS_JOIN_TICKETS;

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

    public List<Object[]> findAll() {
        return entityManager.createNativeQuery(SELECT_EVENTS_JOIN_TICKETS).getResultList();
    }
}
