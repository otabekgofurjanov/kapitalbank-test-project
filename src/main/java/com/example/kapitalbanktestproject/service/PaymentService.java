package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Payment;
import com.example.kapitalbanktestproject.model.MakePayment;
import com.example.kapitalbanktestproject.repository.PaymentRepository;
import com.example.kapitalbanktestproject.service.dto.PaymentDTO;
import com.example.kapitalbanktestproject.service.mapper.PaymentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public PaymentDTO create(PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.toEntity(paymentDTO);
        payment = paymentRepository.save(payment);
        return paymentMapper.toDto(payment);
    }

    public MakePayment getPaymentByInvId(Long invoiceId) {
        MakePayment result = new MakePayment();
        result.setStatus("succes");
        result.setAmount(paymentRepository.getPaymentByInvoiceId(invoiceId).getAmount());
        result.setInvoiceId(paymentRepository.getPaymentByInvoiceId(invoiceId).getInvoiceId());
        result.setTimestamp(paymentRepository.getPaymentByInvoiceId(invoiceId).getTimestamp());
        return result;
    }

    @Transactional(readOnly = true)
    public Page<PaymentDTO> findAllPagingList(Pageable pageable) {
        return paymentRepository.findAll(pageable).map(paymentMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<PaymentDTO> findAllList() {
        return paymentMapper.toDto(paymentRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<PaymentDTO> findOne(Long id) {
        return paymentRepository.findById(id).map(paymentMapper::toDto);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
