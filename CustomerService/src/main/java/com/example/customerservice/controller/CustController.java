package com.example.customerservice.controller;

import com.example.customerservice.models.Customer;
import com.example.customerservice.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustController {
    @Autowired
    private CustService custService;

    @GetMapping("/customers")
    List<Customer> getListUser(){
        return custService.getAllUsers();
    }
    @GetMapping("/customers/{id}")
    Customer getUserById(@PathVariable long id){
        return custService.getUserById(id);
    }
}
