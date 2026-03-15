package com.yoot.clinic.medical.service;

import com.yoot.clinic.common.enums.MedicalCategory;
import com.yoot.clinic.common.exception.ResourceNotFoundException;
import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical.mapper.MedicalMapper;
import com.yoot.clinic.medical.repository.MedicalRepostory;
import com.yoot.clinic.medical.dto.MedicalResponse;
import com.yoot.clinic.medical.entity.Medical;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalServiceImpl implements MedicalService {

    private final MedicalRepostory medicalRepostory;
    private final MedicalMapper medicalMapper;

    public PageResponse<MedicalResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        PageResponse<MedicalResponse> response =
                PageResponse.from(medicalRepostory.findAll(pageable).map(medicalMapper::toResponse));
        return response;
    }

    public PageResponse<MedicalResponse> findByCategory(MedicalCategory category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        PageResponse<MedicalResponse> response =
                PageResponse.from(medicalRepostory.findAllByCategory(category,pageable).map(medicalMapper::toResponse));
        return response;
    }

    public MedicalResponse findByCode(String code) {
        return medicalMapper.toResponse(medicalRepostory.findByMedicalCode(code));
    }
}
