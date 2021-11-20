package fr.isika.cda11.ohana.project.common.dto;

import fr.isika.cda11.ohana.project.common.models.Order;
import fr.isika.cda11.ohana.project.common.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountDto {
    private String accountLogin;
    private String accountPassword;
    private LocalDate accountCreationDate;
    private Role role;
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
}
