package fr.isika.cda11.ohana.project.ticketing.models;


import fr.isika.cda11.ohana.project.common.model.Address;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NamedQueries({
        @NamedQuery(name = "Events.IDF.findAll",
                query = "SELECT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '75'" +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '77' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '78' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '92' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '93' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '94' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '95' ")
})
public class Event {

    // TODO Field Validation Errors
    // TODO Other Field Validation Controls if Any

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate = LocalDate.now();

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "end_time")
    private LocalTime endTime;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
            mappedBy = "event",
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ticket> tickets = new ArrayList<>();

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Address address;

    @Transient
    private int ticketQuantity;

    @Transient
    private Ticket ticket;

    @Transient
    private String fullAddress;

    public void addTicket(Ticket ticket) {
        ticket.setEvent(this);
        tickets.add(ticket);
    }
}
