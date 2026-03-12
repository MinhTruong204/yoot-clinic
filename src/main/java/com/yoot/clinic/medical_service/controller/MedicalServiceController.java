package com.yoot.clinic.medical_service.controller;

import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;
import com.yoot.clinic.medical_service.service.MedicalServiceUseCase;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller cho resource {@code /api/medical-services}.
*/
@RestController
@RequestMapping("/api/medical-services")
@RequiredArgsConstructor
@Validated
public class MedicalServiceController {

    private final MedicalServiceUseCase medicalServiceUseCase;

    // GET: /api/medical-services
    @GetMapping(params = {"!category", "!code"})
    public PageResponse<MedicalServiceResponse> findAllActive() {
        return medicalServiceUseCase.findAllActive();
    }


    // GET /api/medical-services?{category}`
    @GetMapping(params = {"category", "!code"})
    public PageResponse<MedicalServiceResponse> findAllActiveByCategory(
            @RequestParam(value = "category") String category
    ) {

        return medicalServiceUseCase.findAllActiveByCategory(category);
    }


    // GET /api/medical-services?{code}`
    @GetMapping(params = {"code", "!category"})
    public MedicalServiceResponse findAllActiveByCode(
            @RequestParam(value = "code")
            @Length(max = 50, message = "Code must not exceed 50 characters") // ERR-REQ-001
            String code
    ) {

        return medicalServiceUseCase.findActiveByCode(code);
    }


}
