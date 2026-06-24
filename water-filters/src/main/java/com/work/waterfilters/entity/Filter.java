package com.work.waterfilters.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "filters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"customer", "model"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Filter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serial_num", nullable = false, length = 45)
    private String serialNum;

    @Column(name = "location", nullable = false, length = 200)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private FilterModels model;
}