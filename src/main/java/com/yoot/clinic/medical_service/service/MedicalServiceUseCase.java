package com.yoot.clinic.medical_service.service;

import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;

public interface MedicalServiceUseCase {

    PageResponse<MedicalServiceResponse> findAllActive();

    MedicalServiceResponse findActiveByCode(String code);

    PageResponse<MedicalServiceResponse> findAllActiveByCategory(String category);

}
