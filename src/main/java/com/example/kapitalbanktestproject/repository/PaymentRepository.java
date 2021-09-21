package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "select new GetPaymentByInvoiceIdResult(p.amount, p.timestamp, p.invoice.id) " +
            "from payments p where p.invoice.id = :id", nativeQuery = true)
    MakePayment getPaymentByInvoiceId(@Param("id") Long id);
}
