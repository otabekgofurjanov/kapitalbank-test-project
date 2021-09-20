package com.example.kapitalbanktestproject.service.mapper;

import com.example.kapitalbanktestproject.domain.Payment;
import com.example.kapitalbanktestproject.service.dto.PaymentDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class})
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {

    @Mapping(source = "invoice.id", target = "invoiceId")
    PaymentDTO toDto(Payment payment);

    @Mapping(source = "invoiceId", target = "invoice")
    Payment toEntity(PaymentDTO paymentDTO);

    default Payment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setId(id);
        return payment;
    }
}
