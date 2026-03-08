package com.yoot.clinic.patient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Patient JPA entity.
 */
@Entity
@Table(name = "patients", indexes = {
        @Index(name = "idx_patients_visit_date", columnList = "visit_date"),
        @Index(name = "idx_patients_deleted", columnList = "is_deleted")
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Format: {@code KL{yyMMdd}-{seq:03d}}. Set once, never changed.
     */
    @Column(name = "patient_code", nullable = false, unique = true, updatable = false)
    private String patientCode;

    /**
     * Global sequence number, used to generate patient_code.
     */
    @Column(name = "code_sequence", nullable = false, updatable = false)
    private int codeSequence;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "birth_year", nullable = false)
    private int birthYear;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;

    @Column(name = "is_deleted", nullable = false)
    @Builder.Default
    private boolean isDeleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
