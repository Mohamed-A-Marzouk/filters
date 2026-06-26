package com.work.waterfilters.repository;

import com.work.waterfilters.entity.FilterModelPhase;
import com.work.waterfilters.entity.FilterModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilterModelPhaseRepository extends JpaRepository<FilterModelPhase, Long> {

}
