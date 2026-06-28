package com.work.waterfilters.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"customer", "model", "phases"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "filters")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serial_num", nullable = false, length = 45)
    private String serialNum;

    @Column(nullable = false, length = 200)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private FilterModel model;

    @JsonIgnore
    @OneToMany(mappedBy = "filter",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FilterPhase> phases = new ArrayList<>();

    public void addPhases(List<FilterModelPhase> phases) {
        if (this.phases == null) {
            this.phases = new ArrayList<>();
        }
        phases.forEach(phase -> {
            FilterPhase filterPhase = new FilterPhase();
            filterPhase.setFilter(this);
            filterPhase.setPhaseNum(phase.getPhaseNum());
            filterPhase.setInstallionDate(LocalDate.now());
            filterPhase.setNextDueDate(LocalDate.now().plusMonths(phase.getPhaseLife()));
            this.phases.add(filterPhase);
        });
    }
}