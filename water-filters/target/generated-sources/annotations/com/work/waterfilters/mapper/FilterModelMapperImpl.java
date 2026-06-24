package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.entity.FilterModels;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-24T14:41:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class FilterModelMapperImpl implements FilterModelMapper {

    @Override
    public FilterModels toEntity(FilterModelDTO filterDTO) {
        if ( filterDTO == null ) {
            return null;
        }

        FilterModels filterModels = new FilterModels();

        if ( filterDTO.getModelId() != null ) {
            filterModels.setModelId( filterDTO.getModelId().longValue() );
        }
        filterModels.setModel( filterDTO.getModel() );
        filterModels.setDescription( filterDTO.getDescription() );
        filterModels.setPrice( filterDTO.getPrice() );
        filterModels.setQuantity( filterDTO.getQuantity() );
        filterModels.setPhasesNum( filterDTO.getPhasesNum() );

        return filterModels;
    }

    @Override
    public FilterModelDTO toDTO(FilterModels filter) {
        if ( filter == null ) {
            return null;
        }

        FilterModelDTO filterModelDTO = new FilterModelDTO();

        if ( filter.getModelId() != null ) {
            filterModelDTO.setModelId( filter.getModelId().intValue() );
        }
        filterModelDTO.setModel( filter.getModel() );
        filterModelDTO.setDescription( filter.getDescription() );
        filterModelDTO.setPrice( filter.getPrice() );
        filterModelDTO.setQuantity( filter.getQuantity() );
        filterModelDTO.setPhasesNum( filter.getPhasesNum() );

        return filterModelDTO;
    }

    @Override
    public List<FilterModelDTO> toDTOList(List<FilterModels> filters) {
        if ( filters == null ) {
            return null;
        }

        List<FilterModelDTO> list = new ArrayList<FilterModelDTO>( filters.size() );
        for ( FilterModels filterModels : filters ) {
            list.add( toDTO( filterModels ) );
        }

        return list;
    }
}
