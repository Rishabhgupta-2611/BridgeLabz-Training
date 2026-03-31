DROP DATABASE IF EXISTS health_clinic_db;
CREATE DATABASE health_clinic_db;
USE health_clinic_db;

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100),
    phone VARCHAR(15),
    consultation_fee DOUBLE,
    is_active BOOLEAN
);

CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    phone VARCHAR(15),
    email VARCHAR(100),
    address TEXT,
    blood_group VARCHAR(10)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date TIMESTAMP,
    status VARCHAR(50),

    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

SELECT a.appointment_id,
       p.name AS patient_name,
       d.name AS doctor_name,
       a.appointment_date
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
WHERE DATE(a.appointment_date) = '2026-02-19'
ORDER BY a.appointment_date;

ALTER TABLE appointments
DROP FOREIGN KEY appointments_ibfk_1;

ALTER TABLE patients DROP PRIMARY KEY;

ALTER TABLE patients
MODIFY patient_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE appointments
ADD CONSTRAINT appointments_ibfk_1
FOREIGN KEY (patient_id)
REFERENCES patients(patient_id);

ALTER TABLE appointments
DROP FOREIGN KEY appointments_ibfk_2;

ALTER TABLE doctors DROP PRIMARY KEY;

ALTER TABLE doctors
MODIFY doctor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE appointments
ADD CONSTRAINT appointments_ibfk_2
FOREIGN KEY (doctor_id)
REFERENCES doctors(doctor_id);

-- ==============================
-- DROP DATABASE (optional clean start)
-- ==============================
DROP DATABASE IF EXISTS health_clinic_db;

-- ==============================
-- CREATE DATABASE
-- ==============================
CREATE DATABASE health_clinic_db;
USE health_clinic_db;

-- ==============================
-- PATIENTS TABLE
-- ==============================
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    phone VARCHAR(15),
    email VARCHAR(100),
    address TEXT,
    blood_group VARCHAR(10)
);

-- ==============================
-- DOCTORS TABLE
-- ==============================
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100),
    phone VARCHAR(15),
    consultation_fee DOUBLE,
    is_active BOOLEAN DEFAULT TRUE
);

-- ==============================
-- APPOINTMENTS TABLE
-- ==============================
CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date TIMESTAMP,
    status VARCHAR(50) DEFAULT 'Scheduled',

    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
        ON DELETE CASCADE
);

-- ==============================
-- VISITS TABLE
-- ==============================
CREATE TABLE visits (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL,
    diagnosis TEXT,
    bill_amount DOUBLE,

    CONSTRAINT fk_visit_appointment
        FOREIGN KEY (appointment_id)
        REFERENCES appointments(appointment_id)
        ON DELETE CASCADE
);

-- ==============================
-- BILLS TABLE
-- ==============================
CREATE TABLE bills (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL,
    total_amount DOUBLE,
    bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_bill_appointment
        FOREIGN KEY (appointment_id)
        REFERENCES appointments(appointment_id)
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS bills;

CREATE TABLE bills (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    visit_id INT NOT NULL,
    total_amount DOUBLE,
    bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_status VARCHAR(20) DEFAULT 'UNPAID',
    payment_date TIMESTAMP NULL,
    payment_mode VARCHAR(50),

    CONSTRAINT fk_bill_visit
        FOREIGN KEY (visit_id)
        REFERENCES visits(visit_id)
        ON DELETE CASCADE
);









