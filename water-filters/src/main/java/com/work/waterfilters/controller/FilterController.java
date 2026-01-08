package com.work.waterfilters.controller;

import com.work.waterfilters.dto.FilterDTO;
import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.mapper.FilterMapper;
import com.work.waterfilters.service.FilterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/filters")
@CrossOrigin("*")
public class FilterController {
    private final FilterService service;

    @GetMapping
    public ResponseEntity<List<FilterDTO>> getAllFilters() {
        return ResponseEntity.ok(service.getAllFilters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilterDTO> getFilterById(Long id) {
        FilterDTO filterDTO = service.getFilterById(id);
        return ResponseEntity.ok(filterDTO);
    }

    @PostMapping
    public ResponseEntity<FilterDTO> createFilter(@RequestBody @Valid FilterDTO filterDTO) {
        return ResponseEntity.status(201).body(service.createFilter(filterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilterDTO> updateFilter(@PathVariable Long id, @RequestBody @Valid FilterDTO filterDTO) {
        try {
            return ResponseEntity.ok(service.updateFilter(id, filterDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiter(@PathVariable Long id) {
        service.deleteFilter(id);
        return ResponseEntity.noContent().build();
    }
}
