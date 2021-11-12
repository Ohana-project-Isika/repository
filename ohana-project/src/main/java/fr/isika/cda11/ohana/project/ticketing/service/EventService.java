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
        List<Object[]> list = eventRepository.findAll();
        System.out.println(list.size());
        for (Object[] o : list)
            System.out.println(o.toString());
        List<Event> result  =  new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//            Object[] row = (Object[]) list.get(i);
//            Event event = (Event) row[0];
//            Ticket ticket = (Ticket) row[1];
//            event.addTicket(ticket);
//            result.add(event);
//        }
        return result;
    }

    public Set<Event> findAllDistinct() {
        List<Event> list = findAll();
        Set<Event> distinct = findAll().stream().filter(distinctByKey(e -> e.getId())).collect(Collectors.toSet());

        for (Event dist : distinct) {
            int count = 0;
            for (Event event : findAll()) {
                if (dist.getId().equals(event.getId())) {
                    for (Ticket ticket : event.getTickets()) {
                        dist.addTicket(ticket);
                        dist.setTicketQuantity(++count);
                        dist.setTicket(ticket);
                    }
                }
            }

            dist.setTickets(dist.getTickets().stream().filter(distinctByKey(t -> t.getId())).collect(Collectors.toSet()));
        }

        return distinct;
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
