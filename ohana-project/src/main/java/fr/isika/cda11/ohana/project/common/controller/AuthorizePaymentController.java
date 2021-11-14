package fr.isika.cda11.ohana.project.common.controller;

import com.paypal.base.rest.PayPalRESTException;
import fr.isika.cda11.ohana.project.common.models.Cart;
import fr.isika.cda11.ohana.project.common.models.OrderDetail;
import fr.isika.cda11.ohana.project.common.models.PaymentServices;
import fr.isika.cda11.ohana.project.event.models.Event;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class AuthorizePaymentController implements Serializable {

    public void pay(Cart cart) {
        System.out.println(cart);
        for (Event event : cart.getEvents()) {
            String product = event.getName();
//        String subtotal = ;
//        String shipping = request.getParameter("shipping");
//        String tax = request.getParameter("tax");
//        String total = request.getParameter("total");
//
        }
//        String product = event.getName();
//        String subtotal = request.getParameter("subtotal");
//        String shipping = request.getParameter("shipping");
//        String tax = request.getParameter("tax");
//        String total = request.getParameter("total");
//
//        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);
//
//        try {
//            PaymentServices paymentServices = new PaymentServices();
//            String approvalLink = paymentServices.authorizePayment(orderDetail);
//
//            response.sendRedirect(approvalLink);
//
//        } catch (PayPalRESTException ex) {
//            request.setAttribute("errorMessage", ex.getMessage());
//            ex.printStackTrace();
//            request.getRequestDispatcher("error.jsp").forward(request, response);
//        }
    }
}
