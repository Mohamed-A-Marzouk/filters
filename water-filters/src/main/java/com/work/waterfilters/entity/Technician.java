package com.work.waterfilters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technicians", uniqueConstraints = {
        @UniqueConstraint(name = "phone", columnNames = "phone")
})
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technician_id")
    private Integer technicianId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", nullable = false, length = 20, unique = true)
    private String phone;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "hire_date", insertable = false, updatable = false)
    private LocalDate hireDate;

    @Column(name = "status")
    private Boolean status;

}