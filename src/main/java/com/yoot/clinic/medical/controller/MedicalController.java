package com.yoot.clinic.medical.controller;

import com.yoot.clinic.common.enums.MedicalCategory;
import com.yoot.clinic.common.exception.InvalidRequestException;
import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical.dto.MedicalResponse;
import com.yoot.clinic.medical.service.MedicalServiceImpl;
import com.yoot.clinic.patient.dto.CreatePatientRequest;
import com.yoot.clinic.patient.dto.PatientResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-services")
@RequiredArgsConstructor
@Validated
public class MedicalController {

    private final MedicalServiceImpl medicalService;

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "20") int size,
            @RequestParam(name = "category", required = false) MedicalCategory category,
            @RequestParam(name = "code", required = false) String code) {
        if(category != null && code != null) {
            throw new InvalidRequestException("Invalid service request combinations");
        }
        if(code != null) {
            return ResponseEntity.ok(medicalService.findByCode(code));
        }
        if(category != null) {
            return ResponseEntity.ok(medicalService.findByCategory(category, page, size));
        }
        else return ResponseEntity.ok(medicalService.findAll(page, size));
    }
}
