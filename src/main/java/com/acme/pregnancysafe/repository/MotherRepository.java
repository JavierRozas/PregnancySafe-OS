package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.Mother;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherRepository extends JpaRepository<Mother, Long> {
}
