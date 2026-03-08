package com.yoot.clinic.patient.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yoot.clinic.patient.entity.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Get next patient_code.
     */
    @Query(value = "SELECT NEXTVAL('patient_code_seq')", nativeQuery = true)
    Integer nextCodeSequence();

    /**
     * Get all active patients, supports search by name.
     */
    @Query("""
            SELECT p FROM Patient p
            WHERE p.isDeleted = false
              AND (:search IS NULL OR LOWER(p.fullName) LIKE LOWER(CONCAT('%', :search, '%')))
            """)
    Page<Patient> findAllActive(@Param("search") String search, Pageable pageable);

    /**
     * Find patient by id, only returns if not deleted.
     */
    Optional<Patient> findByIdAndIsDeletedFalse(Long id);
}
