package com.work.waterfilters.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO {
    private Integer filterId;
    @NotBlank(message = "Model is mandatory")
    @Size(max = 100, message = "Model must be at most 100 characters")
    private String model;
    @NotBlank(message = "Description is mandatory")
    @Size(max = 100, message = "Description must be at most 100 characters")
    private String description;
    @Valid
    private Integer price;
    @Valid
    private Integer quantity;
    @Valid
    private Integer phasesNum;
}
