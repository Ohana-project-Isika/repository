package fr.isika.cda11.ohana.project.event.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Event {

    // TODO Field Validation Errors
    // TODO Other Field Validation Controls if Any

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
            mappedBy = "event",
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ticket> tickets = new HashSet<>();

    /**
     * Adds a ticket to an event bidirectionally
     * @param ticket a ticket to be added
     */
    public void addTickets(Ticket ticket) {
        ticket.setEvent(this);
        tickets.add(ticket);
    }
}







