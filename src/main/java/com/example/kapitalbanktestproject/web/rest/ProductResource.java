package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.service.ProductService;
import com.example.kapitalbanktestproject.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO result = productService.create(productDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        ProductDTO result = productService.update(productDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/products/paging")
    public ResponseEntity<List<ProductDTO>> findAllPagingList(Pageable pageable) {
        Page<ProductDTO> productDTO = productService.findAllPaging(pageable);
        return ResponseEntity.ok().body(productDTO.getContent());
    }

    @GetMapping("/products/list")
    public ResponseEntity<List<ProductDTO>> findAllList() {
        List<ProductDTO> productDTOList = productService.findAllList();
        return ResponseEntity.ok().body(productDTOList);
    }

    @GetMapping("/product/details")
    public ResponseEntity<ProductDTO> findProductDetailsById(@RequestParam Long product_id) {
        Optional<ProductDTO> productDTO = productService.findOne(product_id);
        return ResponseEntity.ok().body(productDTO.get());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProducts(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Deleted product");
    }
}
