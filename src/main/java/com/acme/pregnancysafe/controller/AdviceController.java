package com.acme.pregnancysafe.controller;

import com.acme.pregnancysafe.model.Advice;
import com.acme.pregnancysafe.resource.AdviceResource;
import com.acme.pregnancysafe.resource.SaveAdviceResource;
import com.acme.pregnancysafe.service.AdviceService;
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
public class AdviceController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/obstetricians/{obstetricianId}/videos")
    public Page<AdviceResource> getAllAdvicesByObstetricianId(
            @PathVariable(name = "obstetricianId") Long obstetricianId,
            Pageable pageable) {
        Page<Advice> advicePage = adviceService.getAllAdviceByObstetricianId(obstetricianId, pageable);
        List<AdviceResource> resources = advicePage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/obstetricians/{obstetricianId}/videos/{adviceId}")
    public AdviceResource getAdviceByIdAndObstetricianId(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                                   @PathVariable(name = "adviceId") Long adviceId) {
        return convertToResource(adviceService.getAdviceByIdAndObstetricianId(obstetricianId, adviceId));
    }

    @PostMapping("/obstetricians/{obstetricianId}/videos")
    public AdviceResource createAdvice(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                         @Valid @RequestBody SaveAdviceResource resource) {
        return convertToResource(adviceService.createAdvice(obstetricianId, convertToEntity(resource)));

    }

    @PutMapping("/obstetricians/{obstetricianId}/videos/{adviceId}")
    public AdviceResource updateAdvice(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                         @PathVariable(name = "adviceId") Long adviceId,
                                         @Valid @RequestBody SaveAdviceResource resource) {
        return convertToResource(adviceService.updateAdvice(obstetricianId, adviceId, convertToEntity(resource)));
    }

    @DeleteMapping("/obstetricians/{obstetricianId}/videos/{adviceId}")
    public ResponseEntity<?> deleteAdvice(@PathVariable(name = "obstetricianId") Long obstetricianId,
                                           @PathVariable(name = "adviceId") Long adviceId) {
        return adviceService.deleteAdvice(obstetricianId, adviceId);
    }

    private Advice convertToEntity(SaveAdviceResource resource) {
        return mapper.map(resource, Advice.class);
    }

    private AdviceResource convertToResource(Advice entity) {
        return mapper.map(entity, AdviceResource.class);
    }

}
