package org.example.services.impl;

import org.example.models.Order;
import org.example.services.OrderManagementService;

public class OrderManagementServiceImpl implements OrderManagementService {
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        return new Order[0];
    }

    @Override
    public Order[] getOrders() {
        return new Order[0];
    }
}
