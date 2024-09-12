package fr.isika.cda11.ohana.project.common.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MeansOfPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String fullName;
    private String expiry;
    private String cvc;

    @ManyToOne(cascade = CascadeType.ALL)
    private PrivatePerson privatePerson;
}
