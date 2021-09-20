package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where id=: id", nativeQuery = true)
    Product findByIdProductId(@Param("id") Long id);
}
