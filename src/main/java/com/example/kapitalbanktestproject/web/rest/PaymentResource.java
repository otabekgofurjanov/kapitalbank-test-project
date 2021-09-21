package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.service.PaymentService;
import com.example.kapitalbanktestproject.service.dto.PaymentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
        PaymentDTO result = paymentService.create(paymentDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/payments/paging")
    public ResponseEntity<List<PaymentDTO>> findAllPaging(Pageable pageable) {
        Page<PaymentDTO> result = paymentService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/payments/invoice/{id}")
    public MakePayment getPaymentByInvoiceId(@PathVariable Long id) {
        return paymentService.getPaymentByInvId(id);
    }

    @GetMapping("/payments/list")
    public ResponseEntity<List<PaymentDTO>> findAllList() {
        List<PaymentDTO> paymentDTOList = paymentService.findAllList();
        return ResponseEntity.ok().body(paymentDTOList);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<PaymentDTO> findOne(@PathVariable Long id) {
        Optional<PaymentDTO> paymentDTO = paymentService.findOne(id);
        return ResponseEntity.ok().body(paymentDTO.get());
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.ok("Deleted payment");
    }
}
