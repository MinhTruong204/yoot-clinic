package com.yoot.clinic.patient.mapper;

import com.yoot.clinic.patient.dto.PatientResponse;
import com.yoot.clinic.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {

    PatientResponse toResponse(Patient patient);
}
