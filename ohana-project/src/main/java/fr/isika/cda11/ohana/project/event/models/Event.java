package fr.isika.cda11.ohana.project.event.models;


import fr.isika.cda11.ohana.project.common.models.Address;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NamedQueries({
        @NamedQuery(name = "Events.findAll", query = "SELECT DISTINCT e FROM Event e"),
        @NamedQuery(name = "Events.IDF.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '75' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '77' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '78' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '91' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '92' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '93' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '94' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '95' " ),
        @NamedQuery(name = "Events.HDF.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '02' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '59' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '60' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '62' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '80' " ),
        @NamedQuery(name = "Events.CORSE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '2A' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '2B' " ),
        @NamedQuery(name = "Events.CVDL.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '18' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '28' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '36' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '37' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '41' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '45' " ),
        @NamedQuery(name = "Events.BRETAGNE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '22' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '29' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '35' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '56' " ),
        @NamedQuery(name = "Events.BFC.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '21' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '25' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '39' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '58' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '70' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '71' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '89' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '90' " ),
        @NamedQuery(name = "Events.GE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '08' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '10' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '51' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '52' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '54' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '55' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '57' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '67' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '68' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '88' " ),
        @NamedQuery(name = "Events.OCCITANIE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '09' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '11' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '12' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '30' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '31' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '32' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '34' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '46' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '48' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '65' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '66' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '81' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '82' " ),
        @NamedQuery(name = "Events.ARA.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '01' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '03' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '07' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '15' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '26' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '38' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '42' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '43' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '63' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '69' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '73' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '74' " ),
        @NamedQuery(name = "Events.NORMANDIE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '14' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '27' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '50' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '61' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '76' " ),
        @NamedQuery(name = "Events.PDLL.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '44' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '49' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '53' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '72' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '85' " ),
        @NamedQuery(name = "Events.PACA.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '04' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '05' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '06' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '13' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '83' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '84' " ),
        @NamedQuery(name = "Events.NA.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '16' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '17' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '19' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '23' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '24' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '33' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '40' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '47' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '64' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '79' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '86' " +
                        "OR SUBSTRING(e.address.postCode, 1, 2) = '87' " ),
        @NamedQuery(name = "Events.GUYANE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 3) = '973' " ),
        @NamedQuery(name = "Events.MARTINIQUE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '972' " ),
        @NamedQuery(name = "Events.GUADELOUPE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '971' " ),
        @NamedQuery(name = "Events.REUNION.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '974' " ),
        @NamedQuery(name = "Events.MAYOTTE.findAll",
                query = "SELECT DISTINCT e FROM Event e INNER JOIN e.tickets t WHERE SUBSTRING(e.address.postCode, 1, 2) = '976' " )
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
