-- Tạo sequence toàn cục để sinh số thứ tự cho mã bệnh nhân (patient_code).
CREATE SEQUENCE patient_code_seq START WITH 1 INCREMENT BY 1;

-- Tạo data mẫu cho bảng medical_services.
INSERT INTO medical_services (name, code, category, price, is_active) VALUES ('Khám bệnh cảm', 'KB001', 'DONG_Y', 50.00, true);
INSERT INTO medical_services (name, code, category, price, is_active) VALUES ('Khám bệnh sốt', 'KB002', 'DONG_Y', 30.00, true);
INSERT INTO medical_services (name, code, category, price, is_active) VALUES ('Khám răng', 'KB003', 'KHAC', 100.00, true);
INSERT INTO medical_services (name, code, category, price, is_active) VALUES ('Khám thận', 'KB004', 'TAY_Y', 20.00, true);
INSERT INTO medical_services (name, code, category, price, is_active) VALUES ('Khám tim', 'KB005', 'TAY_Y', 75.00, true);