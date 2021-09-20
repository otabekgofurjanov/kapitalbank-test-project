package com.example.kapitalbanktestproject.web.rest;

import com.example.kapitalbanktestproject.service.CategoryService;
import com.example.kapitalbanktestproject.service.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO result = categoryService.create(categoryDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        CategoryDTO result = categoryService.update(categoryDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/categories/paging")
    public ResponseEntity<List<CategoryDTO>> findAllPaging(Pageable pageable) {
        Page<CategoryDTO> page = categoryService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/categories/list")
    public ResponseEntity<List<CategoryDTO>> findAllList() {
        List<CategoryDTO> categoryDTOList = categoryService.findAllList();
        return ResponseEntity.ok().body(categoryDTOList);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> findOne(@PathVariable Long id) {
        Optional<CategoryDTO> categoryDTO = categoryService.findOne(id);
        return ResponseEntity.ok().body(categoryDTO.get());
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok("Category deleted");
    }
}
