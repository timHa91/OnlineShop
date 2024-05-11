package org.example.services;

import org.example.models.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}
