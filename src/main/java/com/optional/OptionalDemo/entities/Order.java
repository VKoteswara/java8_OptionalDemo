package com.optional.OptionalDemo.entities;


import java.io.Serializable;

public class Order implements Serializable {
    private Long orderId;
    private String orderName;
    private Double price;

    public Order(Long orderId, String orderName, Double price) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", price=" + price +
                '}';
    }
}
