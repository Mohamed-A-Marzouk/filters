package com.work.waterfilters.controller;

import com.work.waterfilters.dto.FilterModelDTO;
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
    public ResponseEntity<List<FilterModelDTO>> getAllFilterModels() {
        return ResponseEntity.ok(service.getAllFilterModels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilterModelDTO> getFilterModelById(Long id) {
        FilterModelDTO filterModelDTO = service.getFilterModelById(id);
        return ResponseEntity.ok(filterModelDTO);
    }

    @PostMapping
    public ResponseEntity<FilterModelDTO> createFilterModel(@RequestBody @Valid FilterModelDTO filterModelDTO) {
        return ResponseEntity.status(201).body(service.createFilterModel(filterModelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilterModelDTO> updateFilterModel(@PathVariable Long id, @RequestBody @Valid FilterModelDTO filterModelDTO) {
        try {
            return ResponseEntity.ok(service.updateFilterModel(id, filterModelDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiterModel(@PathVariable Long id) {
        service.deleteFilterModel(id);
        return ResponseEntity.noContent().build();
    }
}
