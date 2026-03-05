package com.yoot.clinic.patient.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Response DTO for patient resource.
 */
public record PatientResponse(
        Long id,
        String patientCode,
        String fullName,
        int birthYear,
        String address,
        String phoneNumber,
        LocalDate visitDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
