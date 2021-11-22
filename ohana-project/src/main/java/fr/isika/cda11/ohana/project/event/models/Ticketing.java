package fr.isika.cda11.ohana.project.event.models;


import fr.isika.cda11.ohana.project.common.models.Association;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ticketing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "ticketing_name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "rate_type")
    private RATE_TYPE rateType;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "applied_TVA")
    private TVA appliedTVA;

    @Column(name = "pre_tax_price")
    private BigDecimal preTaxPrice = BigDecimal.ZERO;

    private BigDecimal oldPostTaxPrice = BigDecimal.ZERO;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
            mappedBy = "ticketing",
            orphanRemoval = true, fetch = FetchType.EAGER
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Event> events;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Association association;

    @Transient
    private BigDecimal tvaRate = BigDecimal.ZERO;

    @Transient
    private BigDecimal postTaxPrice = BigDecimal.ZERO;
}
