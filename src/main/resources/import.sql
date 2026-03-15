-- Tạo sequence toàn cục để sinh số thứ tự cho mã bệnh nhân (patient_code).
CREATE SEQUENCE patient_code_seq START WITH 1 INCREMENT BY 1;

-- ==================== DỮLIỆU MẪU BẢNG PATIENTS ====================
INSERT INTO patients(patient_code, code_sequence, full_name, birth_year, address, phone_number, visit_date, is_deleted, deleted_at, created_at, updated_at) VALUES('KL260301-001', 1, 'Nguyễn Văn A', 1990, '123 Đường Lê Lợi, Q.1, TP.HCM', '0987654321', '2026-03-08', FALSE, NULL, NOW(), NOW());
INSERT INTO patients(patient_code, code_sequence, full_name, birth_year, address, phone_number, visit_date, is_deleted, deleted_at, created_at, updated_at) VALUES('KL260301-002', 2, 'Trần Thị B', 1985, '456 Đường Nguyễn Huệ, Q.1, TP.HCM', '0976543210', '2026-03-08', FALSE, NULL, NOW(), NOW());

-- ==================== DỮLIỆU MẪU BẢNG MEDICALS ====================
INSERT INTO medicals(medical_code, name, price, category, is_active, is_deleted, deleted_at, created_at, updated_at) VALUES('MED001', 'Paracetamol 500mg', 50000, 0, TRUE, FALSE, NULL, NOW(), NOW());
INSERT INTO medicals(medical_code, name, price, category, is_active, is_deleted, deleted_at, created_at, updated_at) VALUES('MED002', 'Amoxicillin 250mg', 35000, 1, TRUE, FALSE, NULL, NOW(), NOW());

