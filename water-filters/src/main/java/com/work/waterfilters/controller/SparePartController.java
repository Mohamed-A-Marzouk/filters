package com.work.waterfilters.controller;

import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.service.SparePartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/spare-parts")
@CrossOrigin("*")
public class SparePartController {
    private final SparePartService service;

    @GetMapping
    public ResponseEntity<List<SparePartDto>> getAllSparePart() {
        return ResponseEntity.ok(service.getAllSparePart());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SparePartDto> getSparePartById(Long id) {
        SparePartDto sparePartDto = service.getSparePartById(id);
        return ResponseEntity.ok(sparePartDto);
    }

    @PostMapping
    public ResponseEntity<SparePartDto> createSparePart(@RequestBody @Valid SparePartDto sparePartDto) {
        return ResponseEntity.status(201).body(service.createSparePart(sparePartDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SparePartDto> updateSparePart(@PathVariable Long id, @RequestBody @Valid SparePartDto sparePartDto) {
        try {
            return ResponseEntity.ok(service.updateSparePart(id, sparePartDto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSparePart(@PathVariable Long id) {
        service.deleteSparePart(id);
        return ResponseEntity.noContent().build();
    }
}

