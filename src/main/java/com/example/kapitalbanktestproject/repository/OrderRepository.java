package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByCustomerIdAndStatus(Long customerId, String status);
}
