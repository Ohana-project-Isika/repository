package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.event.models.Cart;
import fr.isika.cda11.ohana.project.event.models.Event;

import javax.ejb.Stateless;
import java.math.BigDecimal;

@Stateless
public class AuthorizePaymentService {

    public String computeTotalTax(Cart cart) {
        BigDecimal tax = BigDecimal.ZERO;
        for (Event event : cart.getEvents()) {
            tax.add(event.getTicket().getPostTaxPrice());
        }

        return tax.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
