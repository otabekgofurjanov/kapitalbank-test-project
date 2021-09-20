package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.service.OrderService;
import com.example.kapitalbanktestproject.service.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO result = orderService.create(orderDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/orders/paging")
    public ResponseEntity<List<OrderDTO>> findAllPagingList(Pageable pageable) {
        Page<OrderDTO> result = orderService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/orders/list")
    public ResponseEntity<List<OrderDTO>> findAllList() {
        List<OrderDTO> orderDTOList = orderService.findAllList();
        return ResponseEntity.ok().body(orderDTOList);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDTO> findOne(@PathVariable Long id) {
        Optional<OrderDTO> orderDTO = orderService.findOne(id);
        return ResponseEntity.ok().body(orderDTO.get());
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.ok("Deleted order");
    }
}
