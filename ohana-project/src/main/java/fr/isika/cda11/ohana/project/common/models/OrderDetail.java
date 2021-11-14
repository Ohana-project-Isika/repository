package fr.isika.cda11.ohana.project.common.models;

import java.math.BigDecimal;

public class OrderDetail {
    private String productName;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal total;

    public OrderDetail(String productName, String subtotal, String tax, String total) {
        this.productName = productName;
        this.subtotal = BigDecimal.valueOf(Double.valueOf(subtotal)).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.tax = BigDecimal.valueOf(Double.valueOf(tax)).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.total = BigDecimal.valueOf(Double.valueOf(total)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getProductName() {
        return productName;
    }

    public String getSubtotal() {
        return subtotal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getTax() {
        return tax.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getTotal() {
        return total.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
