package com.acme.pregnancysafe.repository;


import com.acme.pregnancysafe.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository <Video, Long>{

    Page<Video> findByObstetricianId(Long obstetricianId, Pageable pageable);
    Optional<Video> findByIdAndObstetricianId(Long id, Long obstetricianId);
}
