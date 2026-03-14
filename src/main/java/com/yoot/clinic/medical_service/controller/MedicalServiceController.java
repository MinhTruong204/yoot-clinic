package com.yoot.clinic.medical_service.controller;

import com.yoot.clinic.common.exception.ErrorResponse;
import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;
import com.yoot.clinic.medical_service.service.MedicalServiceUseCase;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping
    public PageResponse<MedicalServiceResponse> findAllActive() {
        return medicalServiceUseCase.findAllActive();
    }


    // GET /api/medical-services?{category}`
    @GetMapping(params = {"category"})
    public PageResponse<MedicalServiceResponse> findAllActiveByCategory(
            @RequestParam(value = "category") String category
    ) {

        return medicalServiceUseCase.findAllActiveByCategory(category);
    }


    // GET /api/medical-services?{code}`
    @GetMapping(params = {"code"})
    public MedicalServiceResponse findAllActiveByCode(
            @RequestParam(value = "code")
            @Length(max = 50, message = "Code must not exceed 50 characters") // ERR-REQ-001
            String code
    ) {

        return medicalServiceUseCase.findActiveByCode(code);
    }



    @GetMapping(params = {"category", "code"})
    public ResponseEntity<ErrorResponse> handleExcludeCategoryCode(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "code") String code
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(
                        400,
                        "Bad Request",
                        "Cannot contains category and code parameters at the same time"));
    }


}
