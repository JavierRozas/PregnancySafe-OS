package com.acme.pregnancysafe.service;


import com.acme.pregnancysafe.exception.ResourceNotFoundException;
import com.acme.pregnancysafe.model.Advice;
import com.acme.pregnancysafe.repository.AdviceRepository;
import com.acme.pregnancysafe.repository.ObstetricianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements AdviceService
{
@Autowired
    private ObstetricianRepository obstetricianRepository;

@Autowired
    private AdviceRepository adviceRepository;


    @Override
    public Page<Advice> getAllAdviceByObstetricianId(Long obstetricianId, Pageable pageable) {
        return adviceRepository.findByObstetricianId(obstetricianId,pageable);
    }

    @Override
    public Advice getAdviceByIdAndObstetricianId(Long obstetricianId, Long adviceId) {
        return adviceRepository.findByIdAndObstetricianId(adviceId,obstetricianId)
                .orElseThrow(() -> new ResourceNotFoundException(
                "Advice not found with Id " + adviceId +
                        " and ObstetricianId " + obstetricianId));
    }

    @Override
    public Advice createAdvice(Long obstetricianId, Advice advice) {
        return obstetricianRepository.findById(obstetricianId).map(obstetrician -> {
            advice.setObstetrician(obstetrician);
            return adviceRepository.save(advice);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Obstetrician", "Id", obstetricianId));
    }

    @Override
    public Advice updateAdvice(Long obstetricianId, Long adviceId, Advice adviceDetails) {
        if(!obstetricianRepository.existsById(obstetricianId))
            throw new ResourceNotFoundException("Obstetrician", "Id", obstetricianId);

        return adviceRepository.findById(adviceId).map(advice -> {
            advice.setText(adviceDetails.getText());
            advice.setTitle(adviceDetails.getTitle());
            advice.setPostdate(adviceDetails.getPostdate());
            return adviceRepository.save(advice);
        }).orElseThrow(() -> new ResourceNotFoundException("Advice", "Id", adviceId));
    }

    @Override
    public ResponseEntity<?> deleteAdvice(Long obstetricianId, Long adviceId) {
        return adviceRepository.findByIdAndObstetricianId(adviceId, obstetricianId).map(advice -> {
            adviceRepository.delete(advice);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Advice not found with Id " + adviceId + " and ObstetricianId " + obstetricianId));
    }
}
