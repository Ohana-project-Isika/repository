package fr.isika.cda11.ohana.project.ticketing.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "rate_type")
    private RATE_TYPE rateType;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "applied_TVA")
    private TVA appliedTVA;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "event_id")
    private Event event;
}
