package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Product;
import com.example.kapitalbanktestproject.repository.ProductRepository;
import com.example.kapitalbanktestproject.service.dto.ProductDTO;
import com.example.kapitalbanktestproject.service.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepository.findByIdProductId(productDTO.getId());
        product = productRepository.findByIdProductId(product.getId());
        product.setCategory(product.getCategory());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setName(product.getName());
        product.setPhoto(product.getPhoto());
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaging(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllList() {
        return productMapper.toDto(productRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<ProductDTO> findOne(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
