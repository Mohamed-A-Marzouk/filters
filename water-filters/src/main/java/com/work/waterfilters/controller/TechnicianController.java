package com.work.waterfilters.controller;

import com.work.waterfilters.dto.TechnicianDTO;
import com.work.waterfilters.service.TechnicianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/technicians")
@CrossOrigin("*")
public class TechnicianController {
    private final TechnicianService service;


    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> getAllTechnician() {
        return new ResponseEntity<>(service.getAllTechnician(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> getCustomerById(@PathVariable Long id) {
        TechnicianDTO technicianDTO = service.getTechnicianById(id);
        return ResponseEntity.ok(technicianDTO);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> createCustomer(@RequestBody @Valid TechnicianDTO technicianDTO) {
        return new ResponseEntity<>(service.createTechnician(technicianDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicianDTO> updateCustomer(@PathVariable Long id, @RequestBody @Valid TechnicianDTO technicianDTO) {
        try {
            return ResponseEntity.ok(service.updateTechnician(id, technicianDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteTechnician(id);
        return ResponseEntity.noContent().build();
    }

}
