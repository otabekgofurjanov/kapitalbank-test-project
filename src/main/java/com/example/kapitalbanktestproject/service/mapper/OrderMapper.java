package com.example.kapitalbanktestproject.service.mapper;

import com.example.kapitalbanktestproject.domain.Order;
import com.example.kapitalbanktestproject.service.dto.OrderDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {

    @Mapping(source = "customer.id", target = "customerId")
    OrderDTO toDto(Order order);

    @Mapping(source = "customerId", target = "customer")
    Order toEntity(OrderDTO orderDTO);

    default Order fromId(Long id) {
        if (id == null) {
            return null;
        }

        Order order = new Order();
        order.setId(id);
        return order;
    }
}
