package com.work.waterfilters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class FilterDetailsResponse {


    private Long id;
    private String serialNum;
    private String location;
    private Long customerId;
    private Long modelId;
    private List<FilterPhaseDTO> phases;

    @NotNull(message = "Customer is mandatory")
    private Long customerId;

    @NotNull(message = "Model is mandatory")
    private Long modelId;
}
