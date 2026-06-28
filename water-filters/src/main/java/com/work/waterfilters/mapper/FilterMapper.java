package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterRequest;
import com.work.waterfilters.entity.Filter;

import java.util.List;

public final class FilterMapper {

    private FilterMapper() {}

    // Map entity -> DTO
    public static FilterRequest toDto(Filter f) {
        if (f == null) return null;
        return FilterRequest.builder()
                .serialNum(f.getSerialNum())
                .location(f.getLocation())
                .customerId(f.getCustomer() != null ? f.getCustomer().getCustomerId() : null)
                .modelId(f.getModel() != null ? f.getModel().getModelId() : null)
                .build();
    }

    // Create entity from filterRequest (relations intentionally left null; set them in service using getReference)
    public static Filter toEntity(FilterRequest filterRequest) {
        if (filterRequest == null) return null;
        Filter f = new Filter();
        f.setSerialNum(filterRequest.getSerialNum());
        f.setLocation(filterRequest.getLocation());
        return f;
    }

    public static List<FilterRequest> toDTOList(List<Filter> all) {
        return all.stream().map(FilterMapper::toDto).toList();
    }
}
