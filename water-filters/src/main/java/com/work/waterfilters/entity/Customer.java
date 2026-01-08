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
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(name = "Phone_UNIQUE", columnNames = "phone")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", nullable = false, length = 20, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "status")
    private Boolean status;
}
