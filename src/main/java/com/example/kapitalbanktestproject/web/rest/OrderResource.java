package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.model.MakeOrder;
import com.example.kapitalbanktestproject.result.MakeOrderResult;
import com.example.kapitalbanktestproject.service.DetailService;
import com.example.kapitalbanktestproject.service.OrderService;
import com.example.kapitalbanktestproject.service.dto.DetailDTO;
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
    private final DetailService detailService;

    public OrderResource(OrderService orderService, DetailService detailService) {
        this.orderService = orderService;
        this.detailService = detailService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO result = orderService.create(orderDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/order")
    public ResponseEntity<MakeOrderResult> makeOrder(@RequestBody MakeOrder makeOrder) {
        MakeOrderResult result = orderService.makeOrderResult(makeOrder);
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

    @GetMapping("/order/details")
    public ResponseEntity<List<DetailDTO>> findAllDetailsByOrderId(@RequestParam Long order_id) {
        List<DetailDTO> detailDTOList = detailService.findAllByOrderId(order_id);
        return ResponseEntity.ok().body(detailDTOList);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Deleted order");
    }
}
