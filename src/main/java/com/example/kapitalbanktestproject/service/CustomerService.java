package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Customer;
import com.example.kapitalbanktestproject.repository.CustomerRepository;
import com.example.kapitalbanktestproject.service.dto.CustomerDTO;
import com.example.kapitalbanktestproject.service.mapper.CustomerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.findByCustomerId(customer.getId());
        customer.setName(customer.getName());
        customer.setCountry(customer.getCountry());
        customer.setAddress(customer.getAddress());
        customer.setPhone(customer.getPhone());
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    public Customer getById(Long id) {
        Optional<Customer> product = customerRepository.findById(id);
        return product.orElse(null);
    }

    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAllPagingList(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAllList() {
        return customerMapper.toDto(customerRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<CustomerDTO> findOne(Long id) {
        return customerRepository.findById(id).map(customerMapper::toDto);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
