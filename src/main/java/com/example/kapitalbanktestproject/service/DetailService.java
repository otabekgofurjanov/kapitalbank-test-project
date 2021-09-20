package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Detail;
import com.example.kapitalbanktestproject.repository.DetailRepository;
import com.example.kapitalbanktestproject.service.dto.DetailDTO;
import com.example.kapitalbanktestproject.service.mapper.DetailMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailService {

    private final DetailRepository detailRepository;
    private final DetailMapper detailMapper;

    public DetailService(DetailRepository detailRepository, DetailMapper detailMapper) {
        this.detailRepository = detailRepository;
        this.detailMapper = detailMapper;
    }

    public DetailDTO create(DetailDTO detailDTO) {
        Detail detail = detailMapper.toEntity(detailDTO);
        detail = detailRepository.save(detail);
        return detailMapper.toDto(detail);
    }

    public DetailDTO update(DetailDTO detailDTO) {
        Detail detail = detailMapper.toEntity(detailDTO);
        detail = detailRepository.findByDetailId(detail.getId());
        detail.setQuantity(detail.getQuantity());
        detail = detailRepository.save(detail);
        return detailMapper.toDto(detail);
    }

    @Transactional(readOnly = true)
    public Page<DetailDTO> findAllPagingList(Pageable pageable) {
        return detailRepository.findAll(pageable).map(detailMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<DetailDTO> findAllList() {
        return detailMapper.toDto(detailRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<DetailDTO> findOne(Long id) {
        return detailRepository.findById(id).map(detailMapper::toDto);
    }

    public void delete(Long id) {
        detailRepository.deleteById(id);
    }
}
