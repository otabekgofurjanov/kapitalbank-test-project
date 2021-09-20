package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer where id =: id", nativeQuery = true)
    Customer findByCustomerId(@Param("id") Long id);
}
