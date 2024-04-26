package com.example.orderservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "status")
    private String status;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @OneToOne
    private Customer customer;

    public Order(long id, LocalDateTime orderDate, String status, String shippingAddress) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

    public Order( LocalDateTime orderDate, String status, String shippingAddress, Customer customer) {
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.customer = customer;
    }
}