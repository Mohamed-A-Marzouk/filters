package com.work.waterfilters.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhaseDTO {
    @Valid
    private int phaseNumber;
    @Valid
    private int phaseLife;
}
