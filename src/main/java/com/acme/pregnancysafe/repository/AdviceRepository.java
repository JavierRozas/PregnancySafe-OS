package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository <Advice, Long> {
}
