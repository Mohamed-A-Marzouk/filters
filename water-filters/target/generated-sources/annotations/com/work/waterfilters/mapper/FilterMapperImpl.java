package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterDTO;
import com.work.waterfilters.entity.Filter;
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
public class FilterMapperImpl implements FilterMapper {

    @Override
    public Filter toEntity(FilterDTO filterDTO) {
        if ( filterDTO == null ) {
            return null;
        }

        Filter filter = new Filter();

        if ( filterDTO.getFilterId() != null ) {
            filter.setFilterId( filterDTO.getFilterId().longValue() );
        }
        filter.setModel( filterDTO.getModel() );
        filter.setDescription( filterDTO.getDescription() );
        filter.setPrice( filterDTO.getPrice() );
        filter.setQuantity( filterDTO.getQuantity() );
        filter.setPhasesNum( filterDTO.getPhasesNum() );

        return filter;
    }

    @Override
    public FilterDTO toDTO(Filter filter) {
        if ( filter == null ) {
            return null;
        }

        FilterDTO filterDTO = new FilterDTO();

        if ( filter.getFilterId() != null ) {
            filterDTO.setFilterId( filter.getFilterId().intValue() );
        }
        filterDTO.setModel( filter.getModel() );
        filterDTO.setDescription( filter.getDescription() );
        filterDTO.setPrice( filter.getPrice() );
        filterDTO.setQuantity( filter.getQuantity() );
        filterDTO.setPhasesNum( filter.getPhasesNum() );

        return filterDTO;
    }

    @Override
    public List<FilterDTO> toDTOList(List<Filter> filters) {
        if ( filters == null ) {
            return null;
        }

        List<FilterDTO> list = new ArrayList<FilterDTO>( filters.size() );
        for ( Filter filter : filters ) {
            list.add( toDTO( filter ) );
        }

        return list;
    }
}
