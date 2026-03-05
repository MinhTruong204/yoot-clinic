package com.yoot.clinic.patient.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Sinh mã bệnh nhân theo format {@code KL{yyMMdd}-{seq:03d}}. Ví dụ: {@code KL260301-001}.
 */
@Component
public class PatientCodeGenerator {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

    public String generate(LocalDate visitDate, int sequence) {
        Objects.requireNonNull(visitDate, "visitDate must not be null");
        if (sequence < 1 || sequence > 999) {
            throw new IllegalArgumentException(
                    "Day sequence must be between 1 and 999, got: " + sequence);
        }
        return "KL%s-%03d".formatted(visitDate.format(DATE_FORMATTER), sequence);
    }
}
