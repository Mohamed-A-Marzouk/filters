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
@Table(name = "filter_model_phase")
public class FilterModelPhase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filter_model_phase_id")
    private Long id;

    @Column(name = "phase_num", nullable = false)
    private Integer phaseNum;

    @Column(name = "phase_life", nullable = false)
    private Integer phaseLife;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private FilterModels model;

}
