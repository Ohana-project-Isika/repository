package fr.isika.cda11.ohana.project.common.models;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Ticket;
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
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Event> events = new ArrayList<>();

    @ManyToOne
    private Individual individual;

    @Transient
    private BigDecimal subTotal = BigDecimal.ZERO;

    @Transient
    private BigDecimal total = BigDecimal.ZERO;

    public void addEvents(Event event) {
        events.add(event);
    }

    public void addSubTotal(BigDecimal subTotal) {
       this.subTotal = this.subTotal.add(subTotal);
    }

    public void addTotal(BigDecimal total) {
       this.total = this.total.add(total);
    }

    public void subtractSubTotal(BigDecimal subTotal) {
        this.subTotal = this.subTotal.subtract(subTotal);
    }

    public void subtractTotal(BigDecimal total) {
        this.total = this.total.subtract(total);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
        this.updateTotals();
    }

    private void updateTotals() {

    }
}
