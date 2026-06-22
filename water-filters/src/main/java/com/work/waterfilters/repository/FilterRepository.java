package com.work.waterfilters.repository;

import com.work.waterfilters.entity.FilterModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilterRepository extends JpaRepository<FilterModels, Long> {
    Optional<FilterModels> findByModel(String model);
}
