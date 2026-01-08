package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.TechnicianDTO;
import com.work.waterfilters.entity.Technician;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnicianMapper {
    TechnicianDTO toDTO(Technician technician);
    Technician toEntity(TechnicianDTO dto);

    List<TechnicianDTO> toDTOList(List<Technician> technicians);
}
