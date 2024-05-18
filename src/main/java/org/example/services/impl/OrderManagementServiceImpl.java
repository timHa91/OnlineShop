package org.example.services.impl;

import org.example.models.Order;
import org.example.services.OrderManagementService;

import java.util.ArrayList;
import java.util.List;

public class OrderManagementServiceImpl implements OrderManagementService {

    private static OrderManagementServiceImpl instance;
    private final List<Order> orders;

    {
        this.orders = new ArrayList<>();
    }
    @Override
    public void addOrder(Order order) {
        if (order == null ) {
          return;
        }
        this.orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return this.orders.stream()
                .filter(order -> order != null && order.getCustomerId() == userId)
                .toList();
    }

    @Override
    public List<Order> getOrders() {
        return this.orders;
    }

    public static OrderManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderManagementServiceImpl();
        }
        return instance;
    }

    void clearServiceState() {
        orders.clear();
    }
}
