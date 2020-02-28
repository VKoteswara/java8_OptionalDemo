package com.optional.OptionalDemo.services;

import com.optional.OptionalDemo.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public void addOrder(Order order);
    public Optional<List<Order>> getOrderList();
    public Order fetchOrderByOrderName(List<Order> orderList,String orderName);
    public String fetchOrderNameByOrderId(List<Order> orderList, Long orderId);
}
