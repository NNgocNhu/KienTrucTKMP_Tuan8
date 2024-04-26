package com.example.customerservice.repository;

import com.example.customerservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusRepository extends JpaRepository<Customer, Long> {
}
