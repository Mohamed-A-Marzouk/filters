package com.work.waterfilters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TechnicianDTO {

    private Long technicianId;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Phone is mandatory")
    @Size(max = 20, message = "Phone number must be at most 20 characters")
    private String phone;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

    private LocalDate hireDate;
    private Boolean status;
}
