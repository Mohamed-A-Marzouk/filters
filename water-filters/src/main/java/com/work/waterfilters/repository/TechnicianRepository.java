package com.work.waterfilters.repository;

import com.work.waterfilters.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician,Long> {
     Optional<Technician> findByPhone(String phone);
}
