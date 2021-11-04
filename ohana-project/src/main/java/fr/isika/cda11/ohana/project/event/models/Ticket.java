package fr.isika.cda11.ohana.project.event.models;

import lombok.*;

import javax.persistence.*;

/**
 * Created on 11/04/2021
 * @author manu
 */
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

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Event event;
}
