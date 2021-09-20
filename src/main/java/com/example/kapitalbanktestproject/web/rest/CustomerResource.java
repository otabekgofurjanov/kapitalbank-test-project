package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.service.CustomerService;
import com.example.kapitalbanktestproject.service.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO result = customerService.create(customerDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        CustomerDTO result = customerService.update(customerDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/customers/paging")
    public ResponseEntity<List<CustomerDTO>> findAllPagingList(Pageable pageable) {
        Page<CustomerDTO> customerDTOPage = customerService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(customerDTOPage.getContent());
    }

    @GetMapping("/customers/list")
    public ResponseEntity<List<CustomerDTO>> findAllList() {
        List<CustomerDTO> customerDTOList = customerService.findAllList();
        return ResponseEntity.ok().body(customerDTOList);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> findOne(@PathVariable Long id) {
        Optional<CustomerDTO> customerDTO = customerService.findOne(id);
        return ResponseEntity.ok().body(customerDTO.get());
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok("Customer deleted");
    }
}
