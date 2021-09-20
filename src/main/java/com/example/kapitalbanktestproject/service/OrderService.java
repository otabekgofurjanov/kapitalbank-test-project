package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.*;
import com.example.kapitalbanktestproject.model.MakeOrder;
import com.example.kapitalbanktestproject.repository.OrderRepository;
import com.example.kapitalbanktestproject.result.MakeOrderResult;
import com.example.kapitalbanktestproject.service.dto.OrderDTO;
import com.example.kapitalbanktestproject.service.mapper.OrderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;
    private final ProductService productService;
    private final InvoiceService invoiceService;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, CustomerService customerService, ProductService productService, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerService = customerService;
        this.productService = productService;
        this.invoiceService = invoiceService;
    }

    public OrderDTO create(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    public MakeOrderResult makeOrderResult(MakeOrder makeOrder) {
        Order order = new Order();
        order.setDate(new Date());
        Customer customer = customerService.getById(makeOrder.getCustomerId());
        order.setCustomer(customer);
        order = orderRepository.save(order);

        Detail orderDetail = new Detail();
        orderDetail.setOrder(order);
        orderDetail.setQuantity(makeOrder.getQuantity());
        Product product = productService.getById(makeOrder.getProductId());
        orderDetail.setProduct(product);
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmount(makeOrder.getQuantity() * product.getPrice());
        Calendar c = Calendar.getInstance();
        invoice.setIssued(c.getTime());
        c.add(Calendar.DATE, 5);
        invoice.setDue(c.getTime());
        invoiceService.save(invoice);


        MakeOrderResult result = new MakeOrderResult();
        result.setStatus("success");
        result.setInvoiceNum(invoiceService.getInvNumByOrderId(order.getId()));
        return result;
    }

    @Transactional(readOnly = true)
    public Page<OrderDTO> findAllPagingList(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllList() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<OrderDTO> findOne(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }


}
