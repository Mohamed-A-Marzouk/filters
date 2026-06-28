package com.work.waterfilters.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filter_model_phase")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FilterModelPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filter_model_phase_id")
    private Integer filterModelPhaseId;

    @Column(name = "phase_num", nullable = false)
    private Integer phaseNum;

    @Column(name = "phase_life", nullable = false)
    private Integer phaseLife;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private FilterModel model;

    // getters and setters
}