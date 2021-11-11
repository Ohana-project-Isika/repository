package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket{

    private static final long serialVersionUID = 8845474287191812919L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer price;
}
