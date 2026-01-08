package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.TechnicianDTO;
import com.work.waterfilters.entity.Technician;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-16T03:19:17+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class TechnicianMapperImpl implements TechnicianMapper {

    @Override
    public TechnicianDTO toDTO(Technician technician) {
        if ( technician == null ) {
            return null;
        }

        TechnicianDTO technicianDTO = new TechnicianDTO();

        if ( technician.getTechnicianId() != null ) {
            technicianDTO.setTechnicianId( technician.getTechnicianId().longValue() );
        }
        technicianDTO.setName( technician.getName() );
        technicianDTO.setPhone( technician.getPhone() );
        technicianDTO.setAddress( technician.getAddress() );
        technicianDTO.setHireDate( technician.getHireDate() );
        technicianDTO.setStatus( technician.getStatus() );

        return technicianDTO;
    }

    @Override
    public Technician toEntity(TechnicianDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Technician technician = new Technician();

        if ( dto.getTechnicianId() != null ) {
            technician.setTechnicianId( dto.getTechnicianId().intValue() );
        }
        technician.setName( dto.getName() );
        technician.setPhone( dto.getPhone() );
        technician.setAddress( dto.getAddress() );
        technician.setHireDate( dto.getHireDate() );
        technician.setStatus( dto.getStatus() );

        return technician;
    }

    @Override
    public List<TechnicianDTO> toDTOList(List<Technician> technicians) {
        if ( technicians == null ) {
            return null;
        }

        List<TechnicianDTO> list = new ArrayList<TechnicianDTO>( technicians.size() );
        for ( Technician technician : technicians ) {
            list.add( toDTO( technician ) );
        }

        return list;
    }
}
