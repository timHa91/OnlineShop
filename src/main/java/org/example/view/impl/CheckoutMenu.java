package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Order;
import org.example.models.impl.OrderImpl;
import org.example.services.impl.OrderManagementServiceImpl;
import org.example.view.Menu;

import java.util.Scanner;

public class CheckoutMenu implements Menu {

    private final OrderManagementServiceImpl orderManagementService;
    private final ApplicationContext applicationContext;

    {
        applicationContext = ApplicationContext.getInstance();
        orderManagementService = OrderManagementServiceImpl.getInstance();
    }

    private final String CREDIT_CARD_PROMPT = "Enter your credit card number without spaces and press enter if you confirm purchase";
    private final String CREDIT_CARD_VALIDATION_ERROR = "You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.";
    private final String CHECKOUT_SUCCESS = "Thanks a lot for your purchase. Details about order delivery are sent to your email.";
    @Override
    public void start() {
        printMenuHeader();
        System.out.println(CREDIT_CARD_PROMPT);
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String creditCardNumber = scanner.next();

            if (!createOrder(creditCardNumber)) {
                continue;
            }
            applicationContext.getSessionCart().clear();
            break;
        }
        System.out.println(CHECKOUT_SUCCESS);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHECKOUT MENU *****");
    }

    private boolean createOrder(String creditCardNumber) {
        Order order = new OrderImpl();
        if (!order.isCreditCardNumberValid(creditCardNumber)) {
            System.out.println(CREDIT_CARD_VALIDATION_ERROR);
            return false;
        }
        order.setCreditCardNumber(creditCardNumber);
        order.setCustomerId(applicationContext.getLoggedInUser().getId());
        order.setProducts(applicationContext.getSessionCart().getProducts());
        orderManagementService.addOrder(order);
        return true;
    }
}
