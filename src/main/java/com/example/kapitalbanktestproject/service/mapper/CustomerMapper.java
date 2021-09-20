package com.example.kapitalbanktestproject.service.mapper;

import com.example.kapitalbanktestproject.domain.Customer;
import com.example.kapitalbanktestproject.service.dto.CustomerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
