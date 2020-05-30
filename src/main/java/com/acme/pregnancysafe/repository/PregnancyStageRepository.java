package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.PregnancyStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregnancyStageRepository extends JpaRepository<PregnancyStage, Long> {
}
