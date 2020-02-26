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
    public  ResponseEntity<String> addOrder(@RequestBody(required=false) Order order){
        Order optional= Optional.ofNullable(order).orElseThrow(()->new IllegalArgumentException("Please input argument"));
        orderService.addOrder(optional);
        return ResponseEntity.ok("Order is added sucessfully to list");
    }
    @GetMapping("/orders")
    public  ResponseEntity<Optional<List<Order>>> getAllOrderList(){
        Optional<List<Order>> orderList = orderService.getOrderList();
        return ResponseEntity.ok(orderList);

    }

    @GetMapping("/fetchorderid/{orderName}")
    public ResponseEntity<Order> fetchOrderByOrderName(@RequestBody List<Order> orderList,@PathVariable("orderName") String  orderName){
        Optional<String> optional = Optional.of("orderName");

        Order order = orderService.fetchOrderByOrderName(orderList,orderName);
        //Order order1 = order.orElseGet(() -> new Order(0l, "no order", 0.0));
        return  ResponseEntity.ok(order);
    }
}
