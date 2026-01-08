package com.work.waterfilters.service;

import com.work.waterfilters.dto.CustomerDTO;
import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.entity.Customer;
import com.work.waterfilters.entity.SparePart;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.SparePartMapper;
import com.work.waterfilters.repository.SparePartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SparePartService {
    private final SparePartRepository repository;
    private final SparePartMapper mapper;

    public List<SparePartDto> getAllSparePart() {
        return mapper.toDtoList(repository.findAll());
    }

    public SparePartDto getSparePartById(Long id) {
        SparePart sparePart = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Spare Part", "id", id));
        return mapper.toDto(sparePart);
    }

    public SparePartDto createSparePart(SparePartDto sparePartDto) {
        Optional<SparePart> sparePart = repository.findByPartName(sparePartDto.getPartName());
        if (sparePart.isPresent()) {
            throw new PhoneAlreadyExistsException("Spare Part", "Spare Part with name " + sparePartDto.getPartName() + " already exists.");
        }

        SparePart saved = repository.save(mapper.toEntity(sparePartDto));
        return mapper.toDto(saved);
    }

    public SparePartDto updateSparePart(Long id, SparePartDto sparePartDto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setPartName(sparePartDto.getPartName());
                    existing.setPrice(sparePartDto.getPrice());
                    existing.setQuantity(sparePartDto.getQuantity());
                    existing.setPartLife(sparePartDto.getPartLife());
                    if (sparePartDto.getPartDesc() != null) {
                        existing.setPartDesc(sparePartDto.getPartDesc());
                    }
                    return mapper.toDto(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("SparePart", "id", id));

    }

    public void deleteSparePart(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("SparePart", "id", id));
        repository.deleteById(id);
    }
}
