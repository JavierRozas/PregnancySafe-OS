package com.acme.pregnancysafe.service;

import com.acme.pregnancysafe.exception.ResourceNotFoundException;
import com.acme.pregnancysafe.model.Video;
import com.acme.pregnancysafe.repository.ObstetricianRepository;
import com.acme.pregnancysafe.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private ObstetricianRepository obstetricianRepository;

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Page<Video> getAllVideoByObstetricianId(Long obstetricianId, Pageable pageable) {
        return videoRepository.findByObstetricianId(obstetricianId,pageable);
    }

    @Override
    public Video getVideoByIdAndObstetricianId(Long obstetricianId, Long videoId) {
        return videoRepository.findByIdAndObstetricianId(videoId,obstetricianId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Video not found with Id " + videoId +
                                " and ObstetricianId " + obstetricianId));
    }

    @Override
    public Video createVideo(Long obstetricianId, Video video) {
        return obstetricianRepository.findById(obstetricianId).map(obstetrician -> {
            video.setObstetrician(obstetrician);
            return videoRepository.save(video);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Obstetrician", "Id", obstetricianId));
    }

    @Override
    public Video updateVideo(Long obstetricianId, Long videoId, Video videoDetails) {
        if(!obstetricianRepository.existsById(obstetricianId))
            throw new ResourceNotFoundException("Obstetrician", "Id", obstetricianId);

        return videoRepository.findById(videoId).map(video -> {
            video.setUrl(videoDetails.getUrl());
            video.setTitle(videoDetails.getTitle());
            video.setPostdate(videoDetails.getPostdate());
            return videoRepository.save(video);
        }).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", videoId));
    }

    @Override
    public ResponseEntity<?> deleteVideo(Long obstetricianId, Long videoId) {
        return videoRepository.findByIdAndObstetricianId(videoId, obstetricianId).map(video -> {
            videoRepository.delete(video);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Video not found with Id " + videoId + " and ObstetricianId " + obstetricianId));
    }
}
