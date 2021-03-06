package com.example.kapitalbanktestproject.service.mapper;

import com.example.kapitalbanktestproject.domain.Category;
import com.example.kapitalbanktestproject.service.dto.CategoryDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    default Category fromId(Long id) {
        if (id == null) {
            return null;
        }

        Category category = new Category();
        category.setId(id);
        return category;
    }
}
