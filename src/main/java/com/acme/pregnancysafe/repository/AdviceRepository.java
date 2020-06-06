package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviceRepository extends JpaRepository <Advice, Long> {
    Page<Advice> findByObstetricianId(Long obstetricianId, Pageable pageable);
    Optional<Advice> findByIdAndObstetricianId(Long id, Long obstetricianId);
}
