package com.example.kapitalbanktestproject.service;

import com.example.kapitalbanktestproject.domain.Category;
import com.example.kapitalbanktestproject.repository.CategoryRepository;
import com.example.kapitalbanktestproject.service.dto.CategoryDTO;
import com.example.kapitalbanktestproject.service.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.findByCategoryId(category.getId());
        category.setName(category.getName());
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPagingList(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAllList() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<CategoryDTO> findOne(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::toDto);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
