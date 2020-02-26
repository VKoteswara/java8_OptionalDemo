package com.optional.OptionalDemo.serviceImpls;

import com.optional.OptionalDemo.entities.Order;
import com.optional.OptionalDemo.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {

    private final List<Order> orderList = new ArrayList<>();
    @Override
    public void addOrder(Order order) {

        orderList.add(order);
    }

    @Override
    public Optional<List<Order>> getOrderList() {
        return Optional.of(orderList);
    }

    @Override
    public Order fetchOrderByOrderName(List<Order> orderList1,String orderName) {
        Predicate<Order> predicate = order -> orderName.equalsIgnoreCase(order.getOrderName());
        Optional<Order> any = orderList1.stream().filter(predicate).findAny();
        Order order1 = any.orElseGet(() -> new Order(0l, "no order", 0.0));
        //return any.get();
        return order1;
    }
}
