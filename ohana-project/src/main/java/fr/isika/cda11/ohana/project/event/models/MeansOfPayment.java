package fr.isika.cda11.ohana.project.event.models;

import java.math.BigDecimal;

public enum MeansOfPayment {
    VISA(""), MASTERCARD(""), PAYPAL("");

    private final String meansIcon;

    MeansOfPayment(String meansIcon) {
        this.meansIcon = meansIcon;
    }
}
