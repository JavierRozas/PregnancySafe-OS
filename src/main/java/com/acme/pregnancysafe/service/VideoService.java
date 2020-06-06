package com.acme.pregnancysafe.service;

import com.acme.pregnancysafe.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface VideoService {
    Page<Video> getAllVideoByObstetricianId(Long obstetricianId, Pageable pageable);
    Video getVideoByIdAndObstetricianId(Long obstetricianId, Long videoId);
    Video createVideo(Long obstetricianId, Video video);
    Video updateVideo(Long obstetricianId, Long videoId, Video videoDetails);
    ResponseEntity<?> deleteVideo(Long obstetricianId, Long videoId);
}
