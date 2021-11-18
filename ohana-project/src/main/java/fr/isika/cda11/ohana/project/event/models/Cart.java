package fr.isika.cda11.ohana.project.event.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Event> events = new ArrayList<>();

    @Transient
    private BigDecimal subTotal = BigDecimal.ZERO;

    @Transient
    private BigDecimal total = BigDecimal.ZERO;

    public void addEvents(Event event) {
        events.add(event);
    }
    public void addSubTotal(BigDecimal subTotal) {
        setSubTotal(this.subTotal.add(subTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public void addTotal(BigDecimal total) {
        setTotal(this.total.add(total).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
