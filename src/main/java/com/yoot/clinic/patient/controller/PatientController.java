package com.yoot.clinic.patient.controller;

import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.patient.dto.CreatePatientRequest;
import com.yoot.clinic.patient.dto.PatientResponse;
import com.yoot.clinic.patient.dto.UpdatePatientRequest;
import com.yoot.clinic.patient.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller cho resource {@code /api/patients}.
 */
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Validated
public class PatientController {

    private final PatientService patientService;

    // POST /api/patients — FR-01
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponse create(@Valid @RequestBody CreatePatientRequest request) {
        return patientService.create(request);
    }

    // GET /api/patients — FR-02
    @GetMapping
    public PageResponse<PatientResponse> findAll(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", defaultValue = "0") @Min(value = 0, message = "page must be >= 0") int page,
            @RequestParam(name = "size", defaultValue = "20") @Min(value = 1, message = "size must be >= 1") int size) {

        return patientService.findAll(search, page, size);
    }

    // GET /api/patients/{id} — FR-02
    @GetMapping("/{id}")
    public PatientResponse findById(@PathVariable(name = "id") Long id) {
        return patientService.findById(id);
    }

    // PATCH /api/patients/{id} — FR-03
    @PatchMapping("/{id}")
    public PatientResponse update(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody UpdatePatientRequest request) {
        return patientService.update(id, request);
    }

    // DELETE /api/patients/{id} — FR-04
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Long id) {
        patientService.delete(id);
    }
}
