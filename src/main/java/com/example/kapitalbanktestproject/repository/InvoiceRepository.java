package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query(value = "select * from invoice where id =: id", nativeQuery = true)
    Invoice findByInvoiceId(@Param("id") Long id);

    Invoice findByOrderIdAndStatus(Long orderId, String status);
}
