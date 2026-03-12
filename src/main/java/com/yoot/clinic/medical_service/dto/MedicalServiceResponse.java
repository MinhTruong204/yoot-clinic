package com.yoot.clinic.medical_service.dto;

public record MedicalServiceResponse(
        Long id,
        String code,
        String name,
        String category,
        Double price,
        Boolean isActive
) {
}
