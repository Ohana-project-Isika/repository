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

    @Transient
    private Map<Ticket, Integer> ticketsByQuantity = new HashMap<>();

//    public void addEvents(Event event) {
//        events.add(event);
//    }

//    public void setSubTotal(BigDecimal subTotal) {
//       this.subTotal = this.subTotal.add(subTotal);
//    }
//
//    public void setTotal(BigDecimal total) {
//       this.total = total;
//    }

    public void subtractSubTotal(BigDecimal subTotal) {
        this.subTotal = this.subTotal.subtract(subTotal);
    }

    public void subtractTotal(BigDecimal total) {
        this.total = this.total.subtract(total);
    }

//    public void removeEvent(Event event) {
//        this.events.remove(event);
//        this.updateTotals();
//    }


    public void addTicket(Ticket ticket) {
        if(ticketsByQuantity.containsKey(ticket)) {
            increment(ticket);
        } else {
            ticketsByQuantity.put(ticket, 1);
        }
        computeCart();
    }

    public void computeCart() {
        BigDecimal tempsubtotal = BigDecimal.ZERO, temptotal = BigDecimal.ZERO ;
        for(Map.Entry<Ticket,  Integer> entry : ticketsByQuantity.entrySet()) {
        //ticketsByQuantity.forEach((ticket, quantity) -> {
            temptotal = temptotal.add(entry.getKey().getPostTaxPrice().multiply(BigDecimal.valueOf(entry.getValue()))
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
            tempsubtotal = tempsubtotal.add(entry.getKey().getPreTaxPrice().multiply(BigDecimal.valueOf(entry.getValue()))
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        this.setTotal(temptotal);
        this.setSubTotal(tempsubtotal);
    }

    public void increment(Ticket ticket) {
        Integer oldQte = ticketsByQuantity.get(ticket);
        ticketsByQuantity.put(ticket, oldQte + 1);
        computeCart();
    }

    public void decrement(Ticket ticket) {
        Integer oldQte = ticketsByQuantity.get(ticket);
        if(oldQte > 1) {
            ticketsByQuantity.put(ticket, oldQte - 1);
        } else {
            ticketsByQuantity.remove(ticket);
        }
        computeCart();
    }
}
