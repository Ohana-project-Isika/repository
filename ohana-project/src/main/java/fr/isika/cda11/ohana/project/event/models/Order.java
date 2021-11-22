package fr.isika.cda11.ohana.project.event.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = 5167872310791820758L;

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

    @Transient
    private Map<Long, Integer> ticketsByQuantity = new HashMap<>();

    @Transient
    private Map<Long, Ticket> ticketsByIds = new HashMap<>();

    public void subtractSubTotal(BigDecimal subTotal) {
        this.subTotal = this.subTotal.subtract(subTotal);
    }

    public void subtractTotal(BigDecimal total) {
        this.total = this.total.subtract(total);
    }

    public void addTicket(Ticket ticket) {
        if(ticketsByQuantity.containsKey(ticket.getId())) {
            increment(ticket);
        } else {
            addOneTicket(ticket);
        }
        computeCart();
    }

    private void addOneTicket(Ticket ticket) {
        ticket.setQuantity(1);
        ticketsByQuantity.put(ticket.getId(), 1);
        ticketsByIds.put(ticket.getId(), ticket);
    }

    public void computeCart() {
        BigDecimal tempsubtotal = BigDecimal.ZERO, temptotal = BigDecimal.ZERO ;
        for(Entry<Long, Integer> entry : ticketsByQuantity.entrySet()) {

            Ticket ticket = ticketsByIds.get(entry.getKey());
            Integer quantity = entry.getValue();

            ticket.setPreTaxPricePerQuantity(ticket.getPreTaxPrice().multiply(BigDecimal.valueOf(quantity))
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
            ticket.setPostTaxPricePerQuantity(ticket.getPostTaxPrice().multiply(BigDecimal.valueOf(quantity))
                    .setScale(2, BigDecimal.ROUND_HALF_UP));

            temptotal = temptotal.add(ticket.getPostTaxPricePerQuantity());
            tempsubtotal = tempsubtotal.add(ticket.getPreTaxPricePerQuantity());
        }

        this.setTotal(temptotal);
        this.setSubTotal(tempsubtotal);
    }

    public void increment(Ticket ticket) {
        Integer oldQte = ticketsByQuantity.get(ticket.getId());
        Integer newQty = oldQte + 1;

        ticket.setQuantity(newQty);
        ticketsByQuantity.put(ticket.getId(), newQty);
        ticketsByIds.put(ticket.getId(), ticket);

        computeCart();
    }

    public void decrement(Ticket ticket) {
        Integer oldQty = ticketsByQuantity.get(ticket.getId());
        Integer newQty = 0;
        if(oldQty > 1) {
            newQty = oldQty - 1;
            ticket.setQuantity(newQty);
            ticketsByQuantity.put(ticket.getId(), newQty);
            ticketsByIds.put(ticket.getId(), ticket);
        } else {
            removeTicket(ticket);
        }
        computeCart();
    }

    public void removeTicket(Ticket ticket) {
        ticketsByQuantity.remove(ticket.getId());
        ticketsByIds.remove(ticket.getId());
        computeCart();
    }

}
