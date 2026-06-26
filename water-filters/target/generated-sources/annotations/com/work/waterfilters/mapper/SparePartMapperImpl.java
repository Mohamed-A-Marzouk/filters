package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.SparePartDto;
import com.work.waterfilters.entity.SparePart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-25T14:05:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class SparePartMapperImpl implements SparePartMapper {

    @Override
    public SparePart toEntity(SparePartDto sparePartDto) {
        if ( sparePartDto == null ) {
            return null;
        }

        SparePart sparePart = new SparePart();

        if ( sparePartDto.getPartId() != null ) {
            sparePart.setPartId( sparePartDto.getPartId().longValue() );
        }
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

        if ( sparePart.getPartId() != null ) {
            sparePartDto.setPartId( sparePart.getPartId().intValue() );
        }
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
