package com.yoot.clinic.medical_service.repository;

import com.yoot.clinic.common.response.PageResponse;
import com.yoot.clinic.medical_service.dto.MedicalServiceResponse;
import com.yoot.clinic.medical_service.entity.MedicalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalService, Long> {

    @Query(value = "" +
            "SELECT ms " +
            "FROM MedicalService ms " +
            "WHERE ms.isActive = true")
    Page<MedicalService> findAllActive(Pageable pageable);



    @Query(value = "" +
            "SELECT ms " +
            "FROM MedicalService ms " +
            "WHERE ms.isActive = true and ms.category = :category")
    Page<MedicalService> findAllActiveByCategory(Pageable pageable, String category);


    @Query(value = "" +
            "SELECT ms " +
            "FROM MedicalService ms " +
            "WHERE ms.isActive = true and ms.code = :code")
    Optional<MedicalService> findActiveByCode(String code);


}
