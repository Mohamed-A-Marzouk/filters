package com.work.waterfilters.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.work.waterfilters.dto.PhaseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filter_models")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FilterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;

    @Column(nullable = false, unique = true, length = 100)
    private String model;

    @Column(name = "desciption", nullable = false, length = 1000)
    private String desciption;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "phases_num", nullable = false)
    private Integer phasesNum;

    @JsonIgnore
    @OneToMany(mappedBy = "model",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FilterModelPhase> phases = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "model")
    private List<Filter> filters = new ArrayList<>();

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