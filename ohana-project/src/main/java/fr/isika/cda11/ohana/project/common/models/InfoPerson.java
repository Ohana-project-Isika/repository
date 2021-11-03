package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 11/03/2021
 * @author manu
 */
@Entity
public class InfoPerson /*implements Serializable*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
