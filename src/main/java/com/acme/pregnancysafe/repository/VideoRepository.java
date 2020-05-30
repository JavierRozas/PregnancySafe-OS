package com.acme.pregnancysafe.repository;

import com.acme.pregnancysafe.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository <Video, Long>{
}
