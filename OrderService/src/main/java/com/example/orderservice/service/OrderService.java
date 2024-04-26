package com.example.orderservice.service;

import com.example.orderservice.models.Customer;
import com.example.orderservice.models.Order;
import com.example.orderservice.repositories.OrderRepository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;
//    private final RestTemplate restTemplate;
    private static final String ORDER_SERVICE ="orderService" ;


    RestTemplate restTemplate = new RestTemplate();

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
//        this.restTemplate = restTemplate;
    }

//    @Retry(name = "retryApi")
    @RateLimiter(name = ORDER_SERVICE)
    public List<Order> getListOrder(){
        List<Order> orderList = orderRepository.findAll();
        for (Order o: orderList) {
            Customer customer = restTemplate.getForObject("http://localhost:8080/api/v1/customers/"+o.getId(), Customer                         .class);
            o.setCustomer(customer);
        }
        return orderList;
    }
    public Order getOrderById(long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = restTemplate.getForObject("http://localhost:8080/api/v1/customers/"+id, Customer.class);
        order.setCustomer(customer);
        return order;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id){
        orderRepository.deleteById(id);
    }
}
