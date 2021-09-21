package com.example.kapitalbanktestproject.repository;


import com.example.kapitalbanktestproject.domain.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    @Query(value = "select * from detail where id =: id", nativeQuery = true)
    Detail findByDetailId(@Param("id") Long id);

    List<Detail> findAllByOrderId(Long orderId);
}
