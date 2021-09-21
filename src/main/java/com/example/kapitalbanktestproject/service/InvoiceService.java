package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Invoice;
import com.example.kapitalbanktestproject.repository.InvoiceRepository;
import com.example.kapitalbanktestproject.service.dto.InvoiceDTO;
import com.example.kapitalbanktestproject.service.mapper.InvoiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    public InvoiceDTO create(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    public InvoiceDTO update(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.findByInvoiceId(invoice.getId());
        invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    public Invoice findInvoiceByOrderAndStatus(Long orderId, String status) {
        return invoiceRepository.findByOrderIdAndStatus(orderId, status);
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Transactional(readOnly = true)
    public Page<InvoiceDTO> findAllPagingList(Pageable pageable) {
        return invoiceRepository.findAll(pageable).map(invoiceMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAllList() {
        return invoiceMapper.toDto(invoiceRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<InvoiceDTO> findOne(Long id) {
        return invoiceRepository.findById(id).map(invoiceMapper::toDto);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }
}
