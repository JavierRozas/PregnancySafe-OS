package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.Obstetrician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObstetricianRepository extends JpaRepository<Obstetrician, Long> {
}
