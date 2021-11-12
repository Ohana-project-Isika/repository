package fr.isika.cda11.ohana.project.common.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created on 11/11/2021
 * @author manu
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "street_number")
    private Integer number;

    @Enumerated(value = EnumType.STRING)
    private Suffix suffix;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_complement")
    private String streetComplement;

    private String postCode;
    private String city;
}
