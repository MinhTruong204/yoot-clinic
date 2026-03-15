package com.yoot.clinic.medical.mapper;

import com.yoot.clinic.medical.dto.MedicalResponse;
import com.yoot.clinic.medical.entity.Medical;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalMapper {
    MedicalResponse toResponse(Medical medical);
}
