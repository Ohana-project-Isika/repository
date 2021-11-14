package fr.isika.cda11.ohana.project.event.repository;

import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Event> findAllEventsIDF() { return entityManager.createNamedQuery("Events.IDF.findAll").getResultList(); }

    public List<Event> findAllEvents() { return entityManager.createNamedQuery("Events.findAll").getResultList(); }

    public List<Event> findAllEventsCORSE() {
        return entityManager.createNamedQuery("Events.CORSE.findAll").getResultList();
    }

    public List<Event> findAllEventsCVDL() {
        return entityManager.createNamedQuery("Events.CVDL.findAll").getResultList();
    }

    public List<Event> findAllEventsBRETAGNE() {
        return entityManager.createNamedQuery("Events.BRETAGNE.findAll").getResultList();
    }

    public List<Event> findAllEventsBFC() {
        return entityManager.createNamedQuery("Events.BFC.findAll").getResultList();
    }

    public List<Event> findAllEventsGE() {
        return entityManager.createNamedQuery("Events.GE.findAll").getResultList();
    }

    public List<Event> findAllEventsOCCITANIE() {
        return entityManager.createNamedQuery("Events.OCCITANIE.findAll").getResultList();
    }

    public List<Event> findAllEventsHDF() {
        return entityManager.createNamedQuery("Events.HDF.findAll").getResultList();
    }

    public List<Event> findAllEventsARA() {
        return entityManager.createNamedQuery("Events.ARA.findAll").getResultList();
    }

    public List<Event> findAllEventsNORMANDIE() {
        return entityManager.createNamedQuery("Events.NORMANDIE.findAll").getResultList();
    }

    public List<Event> findAllEventsPDLL() {
        return entityManager.createNamedQuery("Events.PDLL.findAll").getResultList();
    }

    public List<Event> findAllEventsPACA() {
        return entityManager.createNamedQuery("Events.PACA.findAll").getResultList();
    }

    public List<Event> findAllEventsNA() {
        return entityManager.createNamedQuery("Events.NA.findAll").getResultList();
    }

    public List<Event> findAllEventsGUYANE() {
        return entityManager.createNamedQuery("Events.GUYANE.findAll").getResultList();
    }

    public List<Event> findAllEventsMARTINIQUE() {
        return entityManager.createNamedQuery("Events.MARTINIQUE.findAll").getResultList();
    }

    public List<Event> findAllEventsMAYOTTE() {
        return entityManager.createNamedQuery("Events.MAYOTTE.findAll").getResultList();
    }

    public List<Event> findAllEventsGUADELOUPE() {
        return entityManager.createNamedQuery("Events.GUADELOUPE.findAll").getResultList();
    }

    public List<Event> findAllEventsREUNION() {
        return entityManager.createNamedQuery("Events.REUNION.findAll").getResultList();
    }
}
