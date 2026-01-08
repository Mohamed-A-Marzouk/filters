package com.work.waterfilters.service;

import com.work.waterfilters.dto.TechnicianDTO;
import com.work.waterfilters.entity.Technician;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.TechnicianMapper;
import com.work.waterfilters.repository.TechnicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TechnicianService {
    private final TechnicianRepository repository;
    private final TechnicianMapper mapper;

    public List<TechnicianDTO> getAllTechnician() {
        return mapper.toDTOList(repository.findAll());
    }

    public TechnicianDTO getTechnicianById(Long id) {
        Technician technician = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Technician", "id", id));
        return mapper.toDTO(technician);
    }

    public TechnicianDTO createTechnician(TechnicianDTO technicianDTO) {
        Optional<Technician> technician = repository.findByPhone(technicianDTO.getPhone());
        if (technician.isPresent()) {
            throw new PhoneAlreadyExistsException("Technician", "Technician with phone " + technicianDTO.getPhone() + " already exists.");
        }
        technicianDTO.setHireDate(LocalDate.now());
        Technician saved = repository.save(mapper.toEntity(technicianDTO));
        return mapper.toDTO(saved);
    }

    public TechnicianDTO updateTechnician(Long id, TechnicianDTO technicianDetails) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(technicianDetails.getName());
                    existing.setPhone(technicianDetails.getPhone());
                    existing.setAddress(technicianDetails.getAddress());
                    if (technicianDetails.getStatus() != null) {
                        existing.setStatus(technicianDetails.getStatus());
                    }
                    return mapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Technician", "id", id));

    }
    public void deleteTechnician(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Technician", "id", id));
        repository.deleteById(id);
    }

}
