package fr.isika.cda11.ohana.project.common.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;

//    @OneToMany(mappedBy = "individual")
//    private List<Order> orders;
}
