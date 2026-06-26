package com.work.waterfilters.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterDto {
    private Long id;

    @NotBlank(message = "Serial number is mandatory")
    @Size(max = 100)
    private String serialNum;

    @Size(max = 200)
    private String location;

    @NotNull(message = "Customer is mandatory")
    private Long customerId;

    @NotNull(message = "Model is mandatory")
    private Long modelId;

}

