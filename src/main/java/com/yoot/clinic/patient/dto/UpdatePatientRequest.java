package com.yoot.clinic.patient.dto;

import com.yoot.clinic.common.validation.CurrentOrPastYear;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Request body for {@code PATCH /api/patients/{id}}.
 */
public record UpdatePatientRequest(

        @NotBlank(message = "fullName is required and must not be blank")
        String fullName,

        @NotNull(message = "birthYear is required")
        @Min(value = 1900, message = "birthYear must be >= 1900")
        @CurrentOrPastYear
        Integer birthYear,

        @Size(max = 255, message = "address must be at most 255 characters")
        String address,

        String phoneNumber) {

}
