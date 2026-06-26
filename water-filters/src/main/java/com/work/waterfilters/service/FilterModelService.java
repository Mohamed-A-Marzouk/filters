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

    public List<FilterModelDTO> getAllFilterModels() {
        return FilterModelMapper.toDTOList(repository.findAll());
    }

    public FilterModelDTO getFilterModelById(Long id) {
        FilterModels filterModel = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter Model", "id", id+""));
        return FilterModelMapper.toDTO(filterModel);
    }

    public FilterModelDTO createFilterModel(FilterModelDTO filterModelDTO) {
        Optional<FilterModels> filterModel = repository.findByModel(filterModelDTO.getModel());
        if (filterModel.isPresent()) {
            throw new PhoneAlreadyExistsException("Filter Model", "Filter Model " + filterModelDTO.getModel() + " already exists.");
        }

        filterModel = Optional.ofNullable(FilterModelMapper.toEntity(filterModelDTO));
//        filterModel.ifPresent(f -> f.setModel(filterModelDTO.getModel()));
        FilterModels saved = repository.save(filterModel.orElseThrow(() -> new ResourceNotFoundException("Filter Model", "model", filterModelDTO.getModel())));
        return FilterModelMapper.toDTO(saved);
    }

    public FilterModelDTO updateFilterModel(Long id, FilterModelDTO filterModelDTO) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setModel(filterModelDTO.getModel());
                    existing.setPrice(filterModelDTO.getPrice());
                    existing.setQuantity(filterModelDTO.getQuantity());
                    existing.setPhasesNum(filterModelDTO.getPhasesNum());
                    existing.setDescription(filterModelDTO.getDescription());
                    return FilterModelMapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "id", id+""));

    }

    public void deleteFilterModel(Long id) {
        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filter", "id", id+""));
        repository.deleteById(id);
    }

}
