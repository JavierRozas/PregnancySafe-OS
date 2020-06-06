package com.acme.pregnancysafe.service;

import com.acme.pregnancysafe.model.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AdviceService {
    Page<Advice> getAllAdviceByObstetricianId(Long obstetricianId, Pageable pageable);
    Advice getAdviceByIdAndObstetricianId(Long obstetricianId, Long adviceId);
    Advice createAdvice(Long obstetricianId, Advice advice);
    Advice updateAdvice(Long obstetricianId, Long adviceId, Advice adviceDetails);
    ResponseEntity<?> deleteAdvice(Long obstetricianId, Long adviceId);
}
