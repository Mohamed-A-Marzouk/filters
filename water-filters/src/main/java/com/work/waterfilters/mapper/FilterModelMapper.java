package com.work.waterfilters.mapper;

import com.work.waterfilters.dto.FilterModelDTO;
import com.work.waterfilters.entity.FilterModels;


import java.util.ArrayList;
import java.util.List;

public final class FilterModelMapper {
    private FilterModelMapper() {
        /* This utility class should not be instantiated */
    }

    public static FilterModels toEntity(FilterModelDTO filterDTO) {
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
        filterModels.setPhasesNum( filterDTO.getPhases().size() );
        filterModels.addPhases(filterDTO.getPhases());

        return filterModels;
    }

    public static FilterModelDTO toDTO(FilterModels filter) {
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

    public static List<FilterModelDTO> toDTOList(List<FilterModels> filters) {
        if ( filters == null ) {
            return null;
        }

        List<FilterModelDTO> list = new ArrayList<>( filters.size() );
        for ( FilterModels filterModels : filters ) {
            list.add( toDTO( filterModels ) );
        }

        return list;
    }

}
