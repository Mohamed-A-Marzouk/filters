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
@Table(name = "spare_parts", uniqueConstraints = {
        @UniqueConstraint(name = "part_name", columnNames = "part_name")
})
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Integer partId;

    @Column(name = "part_name", unique = true, nullable = false)
    private String partName;

    @Column(name = "part_desc", length = 1000)
    private String partDesc;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer partLife;
}

