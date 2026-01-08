package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.entity.SparePart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SparePartMapper {
    SparePart toEntity(SparePartDto sparePartDto);
    SparePartDto toDto(SparePart sparePart);

    List<SparePartDto> toDtoList(List<SparePart> spareParts);
}
