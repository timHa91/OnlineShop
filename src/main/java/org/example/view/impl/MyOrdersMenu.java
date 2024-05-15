package org.example.view.impl;

import org.example.configs.ApplicationContext;
import org.example.models.Order;
import org.example.services.impl.OrderManagementServiceImpl;
import org.example.view.Menu;

import java.util.Arrays;

public class MyOrdersMenu implements Menu {

    private static final String NOT_LOGGED_IN_ERROR = "Please, log in or create new account to see list of your orders";
    private static final String NO_ORDERS_ERROR = "Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order";

    private final ApplicationContext applicationContext;
    private final OrderManagementServiceImpl orderManagementService;

    {
        orderManagementService = OrderManagementServiceImpl.getInstance();
        applicationContext = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        if (applicationContext.getLoggedInUser() == null) {
            System.out.println(NOT_LOGGED_IN_ERROR);
        } else {
            printMenuHeader();
            printOrders();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MY ORDERS MENU *****");
    }

    private void printOrders() {
        Order[] orders = orderManagementService
                .getOrdersByUserId(applicationContext.getLoggedInUser().getId());

        if(orders == null || orders.length == 0) {
            System.out.println(NO_ORDERS_ERROR);
            return;
        }

        Arrays.stream(orders)
                .forEach(System.out::println);
    }
}
