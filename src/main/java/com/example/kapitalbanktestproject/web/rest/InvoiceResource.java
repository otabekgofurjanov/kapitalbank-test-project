package com.example.kapitalbanktestproject.web.rest;


import com.example.kapitalbanktestproject.service.InvoiceService;
import com.example.kapitalbanktestproject.service.dto.InvoiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceResource {

    private final InvoiceService invoiceService;

    public InvoiceResource(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoices")
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO result = invoiceService.create(invoiceDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/invoices")
    public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody InvoiceDTO invoiceDTO, @PathVariable Long id) {
        if (invoiceDTO.getId() == null) {
            System.out.println("Invalid id");
        }
        InvoiceDTO result = invoiceService.update(invoiceDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/invoices/paging")
    public ResponseEntity<List<InvoiceDTO>> findAllPaging(Pageable pageable) {
        Page<InvoiceDTO> result = invoiceService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/invoices/list")
    public ResponseEntity<List<InvoiceDTO>> findAllList() {
        List<InvoiceDTO> invoiceDTOList = invoiceService.findAllList();
        return ResponseEntity.ok().body(invoiceDTOList);
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<InvoiceDTO> findOne(@PathVariable Long id) {
        Optional<InvoiceDTO> invoiceDTO = invoiceService.findOne(id);
        return ResponseEntity.ok().body(invoiceDTO.get());
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity deleteInvoice(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.ok("Deleted invoice");
    }
}