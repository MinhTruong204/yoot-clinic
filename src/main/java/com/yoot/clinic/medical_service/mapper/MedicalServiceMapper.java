package com.yoot.clinic.medical_service.mapper;

import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;
import com.yoot.clinic.medical_service.entity.MedicalService;
import com.yoot.clinic.patient.dto.PatientResponse;
import com.yoot.clinic.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalServiceMapper {

    MedicalServiceResponse toResponse(MedicalService medicalService);
}
