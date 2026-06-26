package com.work.waterfilters.controller;

import com.work.waterfilters.dto.FilterDto;
import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.service.FilterModelService;
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
    public ResponseEntity<List<FilterDto>> getAllFilters() {
        return ResponseEntity.ok(service.getAllFilters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilterDto> getFilterById(@PathVariable Long id) {
        FilterDto filterDto = service.getFilterById(id);
        return ResponseEntity.ok(filterDto);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<FilterDto> getFilterBySerialNum(@PathVariable String serialNumber) {
        FilterDto filterDto = service.getFilterBySerialNum(serialNumber);
        return ResponseEntity.ok(filterDto);
    }

    @PostMapping
    public ResponseEntity<FilterDto> createFilter(@RequestBody @Valid FilterDto filterDto) {
        return ResponseEntity.status(201).body(service.createFilter(filterDto));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FilterDto> updateFilterModel(@PathVariable Long id, @RequestBody @Valid FilterModelDTO filterModelDTO) {
//        try {
//            return ResponseEntity.ok(service.updateFilterModel(id, filterModelDTO));
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFiterModel(@PathVariable Long id) {
//        service.deleteFilterModel(id);
//        return ResponseEntity.noContent().build();
//    }
}
