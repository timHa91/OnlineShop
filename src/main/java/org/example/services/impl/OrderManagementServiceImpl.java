package org.example.services.impl;

import org.example.models.Order;
import org.example.services.OrderManagementService;

import java.util.Arrays;
import java.util.Objects;

public class OrderManagementServiceImpl implements OrderManagementService {

    private int orderCount;
    private static OrderManagementServiceImpl instance;

    private static final int DEFAULT_ORDERS_CAPACITY = 10;

    private Order[] orders;

    {
        orders = new Order[DEFAULT_ORDERS_CAPACITY];
    }
    @Override
    public void addOrder(Order order) {
        if (order == null ) {
          return;
        }
        if (orders.length <= orderCount) {
            orders = Arrays.copyOf(orders, orders.length << 1);
        }
        orders[orderCount++] = order;
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        return Arrays.stream(orders)
                .filter(order -> order != null && order.getCustomerId() == userId)
                .toArray(Order[]::new);
    }

    @Override
    public Order[] getOrders() {
        return Arrays.stream(orders)
                .filter(Objects::nonNull)
                .toArray(Order[]::new);
    }

    public static OrderManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderManagementServiceImpl();
        }
        return instance;
    }

    void clearServiceState() {
        orderCount = 0;
        orders = new Order[DEFAULT_ORDERS_CAPACITY];
    }
}
