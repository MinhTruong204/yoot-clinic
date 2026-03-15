package com.yoot.clinic.medical.repository;

import com.yoot.clinic.common.enums.MedicalCategory;
import com.yoot.clinic.medical.entity.Medical;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRepostory extends JpaRepository<Medical, Long> {

        Page<Medical> findAllByCategory(MedicalCategory category, Pageable pageable);

        Medical findByMedicalCode(String medicalCode);
}
