package com.work.waterfilters.repository;

import com.work.waterfilters.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    Optional<Filter> findByModel(String model);
}
