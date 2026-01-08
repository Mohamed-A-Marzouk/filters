package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.entity.SparePart;
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
public class SparePartMapperImpl implements SparePartMapper {

    @Override
    public SparePart toEntity(SparePartDto sparePartDto) {
        if ( sparePartDto == null ) {
            return null;
        }

        SparePart sparePart = new SparePart();

        sparePart.setPartId( sparePartDto.getPartId() );
        sparePart.setPartName( sparePartDto.getPartName() );
        sparePart.setPartDesc( sparePartDto.getPartDesc() );
        sparePart.setPrice( sparePartDto.getPrice() );
        sparePart.setQuantity( sparePartDto.getQuantity() );
        sparePart.setPartLife( sparePartDto.getPartLife() );

        return sparePart;
    }

    @Override
    public SparePartDto toDto(SparePart sparePart) {
        if ( sparePart == null ) {
            return null;
        }

        SparePartDto sparePartDto = new SparePartDto();

        sparePartDto.setPartId( sparePart.getPartId() );
        sparePartDto.setPartName( sparePart.getPartName() );
        sparePartDto.setPartDesc( sparePart.getPartDesc() );
        sparePartDto.setPrice( sparePart.getPrice() );
        sparePartDto.setQuantity( sparePart.getQuantity() );
        sparePartDto.setPartLife( sparePart.getPartLife() );

        return sparePartDto;
    }

    @Override
    public List<SparePartDto> toDtoList(List<SparePart> spareParts) {
        if ( spareParts == null ) {
            return null;
        }

        List<SparePartDto> list = new ArrayList<SparePartDto>( spareParts.size() );
        for ( SparePart sparePart : spareParts ) {
            list.add( toDto( sparePart ) );
        }

        return list;
    }
}
