package com.work.waterfilters.entity;

import com.work.waterfilters.dto.PhaseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filter_models", uniqueConstraints = {
        @UniqueConstraint(name = "model", columnNames = "model")
})
public class FilterModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long modelId;

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

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilterModelPhase> phases;

    public void addPhases(List<PhaseDTO> phases) {
        if (this.phases == null) {
            this.phases = new ArrayList<>();
        }
        phases.forEach(phase -> {
            FilterModelPhase filterModelPhase = new FilterModelPhase();
            filterModelPhase.setPhaseNum(phase.getPhaseNumber());
            filterModelPhase.setPhaseLife(phase.getPhaseLife());
            filterModelPhase.setModel(this);
            this.phases.add(filterModelPhase);
        });
    }
}
