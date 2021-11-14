package fr.isika.cda11.ohana.project.common.models;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Event> events = new ArrayList<>();

    public void addEvents(Event event) {
        events.add(event);
    }
}
