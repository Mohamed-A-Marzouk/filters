package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterDto;
import com.work.waterfilters.entity.Filter;

import java.util.List;

public final class FilterMapper {

    private FilterMapper() {}

    // Map entity -> DTO
    public static FilterDto toDto(Filter f) {
        if (f == null) return null;
        return FilterDto.builder()
                .id(f.getId())
                .serialNum(f.getSerialNum())
                .location(f.getLocation())
                .customerId(f.getCustomer() != null ? f.getCustomer().getCustomerId() : null)
                .modelId(f.getModel() != null ? f.getModel().getModelId() : null)
                .build();
    }

    // Create entity from DTO (relations intentionally left null; set them in service using getReference)
    public static Filter toEntity(FilterDto dto) {
        if (dto == null) return null;
        Filter f = new Filter();
        f.setId(dto.getId());
        f.setSerialNum(dto.getSerialNum());
        f.setLocation(dto.getLocation());
        return f;
    }

    public static List<FilterDto> toDTOList(List<Filter> all) {
        return all.stream().map(FilterMapper::toDto).toList();
    }
}
