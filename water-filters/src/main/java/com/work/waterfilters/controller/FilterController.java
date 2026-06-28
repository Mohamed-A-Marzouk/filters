package com.work.waterfilters.controller;

import com.work.waterfilters.dto.FilterRequest;
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
    public ResponseEntity<List<FilterRequest>> getAllFilters() {
        return ResponseEntity.ok(service.getAllFilters());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<FilterRequest>> getCustomerFilters(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getCustomerFilters(customerId));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FilterRequest> getFilterById(@PathVariable Long id) {
        FilterRequest filterRequest = service.getFilterById(id);
        return ResponseEntity.ok(filterRequest);
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<FilterRequest> getFilterBySerialNum(@PathVariable String serialNumber) {
        FilterRequest filterRequest = service.getFilterBySerialNum(serialNumber);
        return ResponseEntity.ok(filterRequest);
    }

    @PostMapping
    public ResponseEntity<FilterRequest> createFilter(@RequestBody @Valid FilterRequest filterRequest) {
        return ResponseEntity.status(201).body(service.createFilter(filterRequest));
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
