package com.work.waterfilters.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filter_phases")
public class FilterPhase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

//    @Column(name = "filter_id", nullable = false)
//    private Long filterId;

    @Column(name = "installion_date", nullable = false)
    private LocalDate installionDate;

    @Column(name = "next_due_date", nullable = false)
    private LocalDate nextDueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id", nullable = false)
    private Filter filter;

}
