package com.work.waterfilters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filters", uniqueConstraints = {
        @UniqueConstraint(name = "model", columnNames = "model")
})
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filter_id")
    private Long filterId;

    @Column(name = "model", nullable = false, unique = true, length = 100)
    private String model;

    @Column(name = "desciption", nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "phases_num", nullable = false)
    private Integer phasesNum;
}
