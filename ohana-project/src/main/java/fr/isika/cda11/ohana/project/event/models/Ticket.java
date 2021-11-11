package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer ticketPrice;
}
