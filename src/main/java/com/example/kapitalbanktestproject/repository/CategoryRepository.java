package com.example.kapitalbanktestproject.repository;

import com.example.kapitalbanktestproject.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select  * from category where id = :id", nativeQuery = true)
    Category findByCategoryId(@Param("id") Long id);
}
