package com.work.waterfilters.entity;

import com.work.waterfilters.dto.PhaseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Long id;

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

    @OneToMany(mappedBy = "filter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilterPhase> phases;

    public void addPhases(List<FilterModelPhase> phases) {
        if (this.phases == null) {
            this.phases = new ArrayList<>();
        }
        phases.forEach(phase -> {
            FilterPhase filterPhase = new FilterPhase();
            filterPhase.setFilter(this);
            filterPhase.setInstallionDate(LocalDate.now());
            filterPhase.setNextDueDate(LocalDate.now().plusMonths(phase.getPhaseLife()));
            this.phases.add(filterPhase);
        });
    }
}