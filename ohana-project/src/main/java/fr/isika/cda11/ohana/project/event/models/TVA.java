package fr.isika.cda11.ohana.project.event.models;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Created on 11/11/2021
 * @author manu
 */
@Getter
public enum TVA {

    CORSE(BigDecimal.valueOf(.009), BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)),
    DOM(BigDecimal.valueOf(.0105), BigDecimal.valueOf(.05), BigDecimal.valueOf(.05), BigDecimal.valueOf(.013)),
    METROPOLITAN(BigDecimal.valueOf(.021), BigDecimal.valueOf(.055), BigDecimal.valueOf(.01), BigDecimal.valueOf(.02));

    private final BigDecimal superReducedRate;
    private final BigDecimal reducedRate1;
    private final BigDecimal reducedRate2;
    private final BigDecimal regularRate;

    TVA(BigDecimal superReducedRate, BigDecimal reducedRate1, BigDecimal reducedRate2, BigDecimal regularRate) {
        this.superReducedRate = superReducedRate;
        this.reducedRate1 = reducedRate1;
        this.reducedRate2 = reducedRate2;
        this.regularRate = regularRate;
    }
}
