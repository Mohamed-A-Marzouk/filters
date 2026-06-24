package com.work.waterfilters.service;

import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.entity.FilterModels;
import com.work.waterfilters.exception.PhoneAlreadyExistsException;
import com.work.waterfilters.exception.ResourceNotFoundException;
import com.work.waterfilters.mapper.FilterModelMapper;
import com.work.waterfilters.repository.FilterModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilterModelService {
    private final FilterModelRepository repository;
    private final FilterModelMapper mapper;

    public List<FilterModelDTO> getAllFilterModels() {
        return mapper.toDTOList(repository.findAll());
    }

    public FilterModelDTO getFilterModelById(Long id) {
        FilterModels filterModel = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter Model", "id", id));
        return mapper.toDTO(filterModel);
    }

    public FilterModelDTO createFilterModel(FilterModelDTO filterModelDTO) {
        Optional<FilterModels> filter = repository.findByModel(filterModelDTO.getModel());
        if (filter.isPresent()) {
            throw new PhoneAlreadyExistsException("Filter", "Filter with model " + filterModelDTO.getModel() + " already exists.");
        }

        FilterModels saved = repository.save(mapper.toEntity(filterModelDTO));
        return mapper.toDTO(saved);
    }

    public FilterModelDTO updateFilterModel(Long id, FilterModelDTO filterModelDTO) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setModel(filterModelDTO.getModel());
                    existing.setPrice(filterModelDTO.getPrice());
                    existing.setQuantity(filterModelDTO.getQuantity());
                    existing.setPhasesNum(filterModelDTO.getPhasesNum());
                    existing.setDescription(filterModelDTO.getDescription());
                    return mapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "id", id));

    }

    public void deleteFilterModel(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter", "id", id));
        repository.deleteById(id);
    }

}
