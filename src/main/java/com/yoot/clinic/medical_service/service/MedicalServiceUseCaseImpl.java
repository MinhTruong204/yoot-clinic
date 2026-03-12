package com.yoot.clinic.medical_service.service;

import com.yoot.clinic.common.exception.ResourceNotFoundException;
import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;
import com.yoot.clinic.medical_service.entity.MedicalService;
import com.yoot.clinic.medical_service.mapper.MedicalServiceMapper;
import com.yoot.clinic.medical_service.repository.MedicalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MedicalServiceUseCaseImpl implements MedicalServiceUseCase {

    private final MedicalServiceRepository medicalServiceRepository;
    private final MedicalServiceMapper medicalServiceMapper;


    @Override
    public PageResponse<MedicalServiceResponse> findAllActive() {
        return PageResponse.from(
                medicalServiceRepository.findAllActive(
                            Pageable.unpaged(Sort.by("code").ascending())
                        )
                        .map(medicalServiceMapper::toResponse));
    }

    @Override
    public MedicalServiceResponse findActiveByCode(String code) {
        MedicalService medicalService = medicalServiceRepository.findActiveByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy dịch vụ", code)); // Throw ERR-MED-001

        return medicalServiceMapper.toResponse(medicalService);
    }

    @Override
    public PageResponse<MedicalServiceResponse> findAllActiveByCategory(String category) {
        return PageResponse.from(
                medicalServiceRepository.findAllActiveByCategory(
                                Pageable.unpaged(Sort.by("code").ascending()), category
                        )
                        .map(medicalServiceMapper::toResponse));
    }
}
