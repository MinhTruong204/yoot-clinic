package com.yoot.clinic.medical.dto;

import com.yoot.clinic.common.enums.MedicalCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalResponse {
    private Long id;
    private String medicalCode;
    private String name;
    private BigDecimal price;
    private MedicalCategory category;
    private Boolean isActive;

}
