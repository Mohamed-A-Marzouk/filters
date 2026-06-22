package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.entity.FilterModels;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilterMapper {
    FilterModels toEntity(FilterModelDTO filterDTO);
    FilterModelDTO toDTO(FilterModels filter);
    List<FilterModelDTO> toDTOList(List<FilterModels> filters);
}
