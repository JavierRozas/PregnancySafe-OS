package com.acme.pregnancysafe.controller;

import com.acme.pregnancysafe.model.Video;
import com.acme.pregnancysafe.resource.SaveVideoResource;
import com.acme.pregnancysafe.resource.VideoResource;
import com.acme.pregnancysafe.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VideoService videoService;

    @GetMapping("/obstetricians/{obstetricianId}/videos")
    public Page<VideoResource> getAllVideosByObstetricianId(
            @PathVariable(name = "obstetricianId") Long obstetricianId,
            Pageable pageable) {
        Page<Video> videoPage = videoService.getAllVideoByObstetricianId(obstetricianId, pageable);
        List<VideoResource> resources = videoPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/obstetricians/{obstetricianId}/videos/{videoId}")
    public VideoResource getVideoByIdAndObstetricianId(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                                         @PathVariable(name = "videoId") Long videoId) {
        return convertToResource(videoService.getVideoByIdAndObstetricianId(obstetricianId, videoId));
    }

    @PostMapping("/obstetricians/{obstetricianId}/videos")
    public VideoResource createVideo(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                       @Valid @RequestBody SaveVideoResource resource) {
        return convertToResource(videoService.createVideo(obstetricianId, convertToEntity(resource)));

    }

    @PutMapping("/obstetricians/{obstetricianId}/videos/{videoId}")
    public VideoResource updateVideo(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                       @PathVariable(name = "videoId") Long videoId,
                                       @Valid @RequestBody SaveVideoResource resource) {
        return convertToResource(videoService.updateVideo(obstetricianId, videoId, convertToEntity(resource)));
    }

    @DeleteMapping("/obstetricians/{obstetricianId}/videos/{videoId}")
    public ResponseEntity<?> deleteAdvice(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                          @PathVariable(name = "videoId") Long videoId) {
        return videoService.deleteVideo(obstetricianId, videoId);
    }

    private Video convertToEntity(SaveVideoResource resource) {
        return mapper.map(resource, Video.class);
    }

    private VideoResource convertToResource(Video entity) {
        return mapper.map(entity, VideoResource.class);
    }

}
