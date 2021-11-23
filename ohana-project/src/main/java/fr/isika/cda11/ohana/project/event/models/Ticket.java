package fr.isika.cda11.ohana.project.event.models;

import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import lombok.*;
import org.primefaces.model.StreamedContent;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    @Column(name = "pre_tax_price")
    private BigDecimal preTaxPrice = BigDecimal.ZERO;

    @ManyToOne(cascade = CascadeType.ALL)
    private PrivatePerson privatePerson;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "event_id")
    private Event event;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Individual_Tickets", joinColumns = @JoinColumn(name = "ticket_id") )
    @Column(name="ticket_amount")
    @MapKeyJoinColumn(name = "individual_id")
    private Map<Individual, Integer> individualTicketsMap = new HashMap<Individual, Integer>();

    @Transient
    private BigDecimal tvaRate = BigDecimal.ZERO;

    @Transient
    private BigDecimal postTaxPrice = BigDecimal.ZERO;

    @Transient
    private int quantity;

    @Transient
    private BigDecimal preTaxPricePerQuantity = BigDecimal.ZERO;

    @Transient
    private BigDecimal postTaxPricePerQuantity = BigDecimal.ZERO;

    @Transient
    private String type;

    @Transient
    private StreamedContent file;
}
