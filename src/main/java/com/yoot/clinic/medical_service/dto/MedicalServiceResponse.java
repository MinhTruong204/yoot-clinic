package com.yoot.clinic.medical_service.dto;

import java.math.BigDecimal;

public record MedicalServiceResponse(
        Long id,
        String code,
        String name,
        String category,
        BigDecimal price,
        Boolean isActive
) {
}
