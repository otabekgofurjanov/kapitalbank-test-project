package com.example.kapitalbanktestproject.web.rest;


import com.example.kapitalbanktestproject.service.DetailService;
import com.example.kapitalbanktestproject.service.dto.DetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DetailResource {

    private final DetailService detailService;

    public DetailResource(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping("/details")
    public ResponseEntity<DetailDTO> createDetail(@RequestBody DetailDTO detailDTO) {
        DetailDTO result = detailService.create(detailDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/details/{id}")
    public ResponseEntity<DetailDTO> updateDetail(@RequestBody DetailDTO detailDTO, @PathVariable Long id) {
        DetailDTO result = detailService.update(detailDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/details/paging")
    public ResponseEntity<List<DetailDTO>> findAllPagingList(Pageable pageable) {
        Page<DetailDTO> detailDTOPage = detailService.findAllPagingList(pageable);
        return ResponseEntity.ok().body(detailDTOPage.getContent());
    }

    @GetMapping("/details/list")
    public ResponseEntity<List<DetailDTO>> findAllList() {
        List<DetailDTO> detailDTOList = detailService.findAllList();
        return ResponseEntity.ok().body(detailDTOList);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<DetailDTO> findOne(@PathVariable Long id) {
        Optional<DetailDTO> detailDTO = detailService.findOne(id);
        return ResponseEntity.ok().body(detailDTO.get());
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity deleteDetails(@PathVariable Long id) {
        detailService.delete(id);
        return ResponseEntity.ok("Deleted detail");
    }
}
