package fr.isika.cda11.ohana.project.ticketing.service;

import fr.isika.cda11.ohana.project.ticketing.models.Event;
import fr.isika.cda11.ohana.project.ticketing.models.Ticket;
import fr.isika.cda11.ohana.project.ticketing.repository.EventRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Stateless
public class EventService {

    @Inject
    private EventRepository eventRepository;

    public void save(Event event) {
        for (int i = 0; i < event.getTicketQuantity(); i++) {
            Ticket ticket = new Ticket();
            ticket.setEvent(event);
            event.getTickets().add(ticket);
            eventRepository.persistEvent(event);
        }
    }

    public List<Event> findAll() {
        List<Event> list = eventRepository.findAll();

        for (Event event : list) {
            event.setTicketQuantity(event.getTickets().size());
            event.setTicket(event.getTickets().get(event.getTickets().size() - 1));
        }

        return list;
    }

    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event update(Event event) {
        eventRepository.update(event);
        return findById(event.getId());
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
