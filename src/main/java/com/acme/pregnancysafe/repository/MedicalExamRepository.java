package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.MedicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExamRepository extends JpaRepository<MedicalExam, Long> {
}
