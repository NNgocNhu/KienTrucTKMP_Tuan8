package com.example.customerservice.service;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repository.CusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CustService {
    private final CusRepository cusRepository;

    public CustService(CusRepository userRepository) {
        this.cusRepository = userRepository;
    }

    public List<Customer> getAllUsers() {
        return cusRepository.findAll();
    }
    public Customer getUserById(long id) {
        return cusRepository.findById(id).get();
    }
}
