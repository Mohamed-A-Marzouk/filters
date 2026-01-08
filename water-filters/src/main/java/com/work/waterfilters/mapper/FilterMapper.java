package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterDTO;
import com.work.waterfilters.entity.Filter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {
    Filter toEntity(FilterDTO filterDTO);
    FilterDTO toDTO(Filter filter);

    List<FilterDTO> toDTOList(List<Filter> filters);
}
