package fr.isika.cda11.ohana.project.event.models;

import fr.isika.cda11.ohana.project.common.models.Address;
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
@NamedQueries({
        @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Event e")
})
public class Event {

    // TODO Field Validation Errors
    // TODO Other Field Validation Controls if Any

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String eventName;
    private String description;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;

    @Transient
    private int ticketQuantity;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
            mappedBy = "event",
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ticket> tickets = new HashSet<>();

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Address address;
}







