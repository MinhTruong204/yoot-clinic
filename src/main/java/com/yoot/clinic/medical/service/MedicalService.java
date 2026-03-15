package com.yoot.clinic.medical.service;

import com.yoot.clinic.common.enums.MedicalCategory;
import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical.dto.MedicalResponse;

public interface MedicalService {
    PageResponse<MedicalResponse> findAll(int page, int size);
    PageResponse<MedicalResponse> findByCategory(MedicalCategory category, int page, int size);
    MedicalResponse findByCode(String code);
}
