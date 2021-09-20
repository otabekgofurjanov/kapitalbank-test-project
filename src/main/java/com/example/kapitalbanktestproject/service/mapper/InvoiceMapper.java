package com.example.kapitalbanktestproject.service.mapper;

import com.example.kapitalbanktestproject.domain.Invoice;
import com.example.kapitalbanktestproject.service.dto.InvoiceDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {

    @Mapping(source = "order.id", target = "orderId")
    InvoiceDTO toDto(Invoice invoice);

    @Mapping(source = "orderId", target = "order")
    Invoice toEntity(InvoiceDTO invoiceDTO);

    default Invoice fromId(Long id) {
        if (id == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(id);
        return invoice;
    }
}
