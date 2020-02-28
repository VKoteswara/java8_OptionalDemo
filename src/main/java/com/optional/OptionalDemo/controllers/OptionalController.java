package com.optional.OptionalDemo.controllers;

import com.optional.OptionalDemo.entities.Order;
import com.optional.OptionalDemo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OptionalController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addorder")
    public ResponseEntity<Order> addOrder(@RequestBody/*(required = false)*/ Order order) {
       // Order optional = Optional.ofNullable(order).orElseThrow(() -> new IllegalArgumentException("Please check input argument"));
        Optional<Order> order1 = Optional.of(order);
        orderService.addOrder(order1.get());
        return ResponseEntity.ok(order1.get());
    }

    @GetMapping("/orders")
    public ResponseEntity<Optional<List<Order>>> getAllOrderList() {
        Optional<List<Order>> orderList = orderService.getOrderList();
        return ResponseEntity.ok(orderList);

    }

    @GetMapping("/fetchorderid/{orderName}")
    public ResponseEntity<Order> fetchOrderByOrderName(@RequestBody List<Order> orderList, @PathVariable(value = "orderName",required = false) String orderName) {
        Optional<String> optional = Optional.ofNullable(orderName);
        Order order = orderService.fetchOrderByOrderName(orderList, orderName);
        return ResponseEntity.ok(order);
    }
    @GetMapping("/fetchordername/{orderId}")
    public ResponseEntity<String> fetchOrderNameByOrderId(@RequestBody List<Order> orderList,@PathVariable("orderId") Long orderId){
        Optional<Long> optionalLong =Optional.ofNullable(orderId);
        String s = orderService.fetchOrderNameByOrderId(orderList, optionalLong.get());
        return ResponseEntity.ok(s);
    }

}
