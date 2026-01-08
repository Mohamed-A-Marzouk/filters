package com.work.waterfilters.service;

import com.work.waterfilters.dto.FilterDTO;
import com.work.waterfilters.entity.Filter;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.FilterMapper;
import com.work.waterfilters.repository.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilterService {
    private final FilterRepository repository;
    private final FilterMapper mapper;

    public List<FilterDTO> getAllFilters() {
        return mapper.toDTOList(repository.findAll());
    }

    public FilterDTO getFilterById(Long id) {
        Filter filter = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter", "id", id));
        return mapper.toDTO(filter);
    }

    public FilterDTO createFilter(FilterDTO filterDTO) {
        Optional<Filter> filter = repository.findByModel(filterDTO.getModel());
        if (filter.isPresent()) {
            throw new PhoneAlreadyExistsException("Filter", "Filter with model " + filterDTO.getModel() + " already exists.");
        }

        Filter saved = repository.save(mapper.toEntity(filterDTO));
        return mapper.toDTO(saved);
    }

    public FilterDTO updateFilter(Long id, FilterDTO filterDTO) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setModel(filterDTO.getModel());
                    existing.setPrice(filterDTO.getPrice());
                    existing.setQuantity(filterDTO.getQuantity());
                    existing.setPhasesNum(filterDTO.getPhasesNum());
                    existing.setDescription(filterDTO.getDescription());
                    return mapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "id", id));

    }

    public void deleteFilter(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter", "id", id));
        repository.deleteById(id);
    }

}
