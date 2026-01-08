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
public class SparePartDto {
    private Integer partId;
    @NotBlank(message = "Part name is mandatory")
    @Size(max = 100, message = "Part name must be at most 100 characters")
    private String partName;
    @Size(max = 100, message = "Part name must be at most 100 characters")
    private String partDesc;
    @Valid
    private Integer price;
    @Valid
    private Integer quantity;
    @Valid
    private Integer partLife;
}
