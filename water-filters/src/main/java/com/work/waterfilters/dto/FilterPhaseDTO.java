package com.work.waterfilters.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilterPhaseDTO {

    private Long id;
    private Integer phaseNum;
    private LocalDate installionDate;
    private LocalDate nextDueDate;
}
