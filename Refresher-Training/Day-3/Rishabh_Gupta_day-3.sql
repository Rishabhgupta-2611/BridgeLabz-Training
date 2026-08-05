CREATE DATABASE clinic_db;
USE clinic_db;

CREATE TABLE Specializations(
    specialization_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Doctors(
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    phone VARCHAR(15),
    specialization_id INT,
    FOREIGN KEY(specialization_id)
    REFERENCES Specializations(specialization_id)
);

CREATE TABLE Patients(
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    dob DATE,
    gender VARCHAR(10),
    phone VARCHAR(15),
    address VARCHAR(100)
);

CREATE TABLE Appointments(
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    status VARCHAR(20),
    FOREIGN KEY(patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY(doctor_id) REFERENCES Doctors(doctor_id)
);

CREATE TABLE VisitHistory(
    visit_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT,
    notes VARCHAR(200),
    visit_date DATE,
    FOREIGN KEY(appointment_id)
    REFERENCES Appointments(appointment_id)
);

CREATE TABLE Billing(
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT,
    amount DECIMAL(10,2),
    payment_status VARCHAR(20),
    bill_date DATE,
    FOREIGN KEY(appointment_id)
    REFERENCES Appointments(appointment_id)
);

INSERT INTO Specializations(name)
VALUES
('Cardiology'),
('Orthopedic'),
('Dermatology');

INSERT INTO Doctors(name,phone,specialization_id)
VALUES
('Dr Raj','9876543210',1),
('Dr Meera','9876543211',2),
('Dr Aman','9876543212',3);

INSERT INTO Patients(name,dob,gender,phone,address)
VALUES
('Rishabh','2003-11-26','Male','9999991111','Varanasi'),
('Rahul','2002-05-10','Male','9999992222','Lucknow'),
('Priya','2001-09-15','Female','9999993333','Delhi');

INSERT INTO Appointments(patient_id,doctor_id,appointment_date,status)
VALUES
(1,1,'2026-08-01','Completed'),
(2,2,'2026-08-02','Pending'),
(3,3,'2026-08-03','Completed');

INSERT INTO VisitHistory(appointment_id,notes,visit_date)
VALUES
(1,'Routine Checkup','2026-08-01'),
(3,'Skin Allergy','2026-08-03');

INSERT INTO Billing(appointment_id,amount,payment_status,bill_date)
VALUES
(1,1500,'Paid','2026-08-01'),
(2,2500,'Pending','2026-08-02'),
(3,1200,'Paid','2026-08-03');

SELECT * FROM Patients;
SELECT * FROM Doctors;
SELECT * FROM Appointments;

SELECT
p.name,
d.name,
a.appointment_date,
a.status
FROM Appointments a
INNER JOIN Patients p
ON a.patient_id=p.patient_id
INNER JOIN Doctors d
ON a.doctor_id=d.doctor_id;

SELECT
p.name,
a.appointment_date
FROM Patients p
LEFT JOIN Appointments a
ON p.patient_id=a.patient_id;

SELECT
d.name,
a.appointment_date
FROM Appointments a
RIGHT JOIN Doctors d
ON a.doctor_id=d.doctor_id;

SELECT
d1.name AS Doctor1,
d2.name AS Doctor2,
d1.specialization_id
FROM Doctors d1
JOIN Doctors d2
ON d1.specialization_id=d2.specialization_id
AND d1.doctor_id<>d2.doctor_id;

SELECT *
FROM Patients
CROSS JOIN Doctors;

SELECT
p.name,
d.name,
s.name,
a.appointment_date,
b.amount
FROM Patients p
JOIN Appointments a
ON p.patient_id=a.patient_id
JOIN Doctors d
ON a.doctor_id=d.doctor_id
JOIN Specializations s
ON d.specialization_id=s.specialization_id
JOIN Billing b
ON a.appointment_id=b.appointment_id;

DELIMITER //

CREATE PROCEDURE GetPatients()
BEGIN
    SELECT * FROM Patients;
END//

DELIMITER ;

CALL GetPatients();

DELIMITER //

CREATE PROCEDURE GetPatientAppointments(IN pid INT)
BEGIN
    SELECT
    p.name,
    d.name,
    a.appointment_date,
    a.status
    FROM Patients p
    JOIN Appointments a
    ON p.patient_id=a.patient_id
    JOIN Doctors d
    ON a.doctor_id=d.doctor_id
    WHERE p.patient_id=pid;
END//

DELIMITER ;

CALL GetPatientAppointments(1);

DELIMITER //

CREATE PROCEDURE TotalBills(OUT totalAmount DECIMAL(10,2))
BEGIN
    SELECT SUM(amount)
    INTO totalAmount
    FROM Billing;
END//

DELIMITER ;

CALL TotalBills(@total);
SELECT @total;

DELIMITER //

CREATE PROCEDURE UpdateBill(
IN bid INT,
INOUT amt DECIMAL(10,2)
)
BEGIN
    UPDATE Billing
    SET amount=amt
    WHERE bill_id=bid;

    SELECT amount
    INTO amt
    FROM Billing
    WHERE bill_id=bid;
END//

DELIMITER ;

SET @a=3000;
CALL UpdateBill(2,@a);
SELECT @a;

DELIMITER //

CREATE PROCEDURE AddPatient(
IN pname VARCHAR(50),
IN pdob DATE,
IN pgender VARCHAR(10),
IN pphone VARCHAR(15),
IN paddress VARCHAR(100)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO Patients(name,dob,gender,phone,address)
    VALUES(pname,pdob,pgender,pphone,paddress);

    COMMIT;
END//

DELIMITER ;

CALL AddPatient(
'Arjun',
'2000-05-01',
'Male',
'9998887776',
'Kanpur'
);

CREATE TABLE PatientAudit(
    audit_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(50),
    action_type VARCHAR(20),
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER before_patient_insert
BEFORE INSERT
ON Patients
FOR EACH ROW
BEGIN
    SET NEW.name=UPPER(NEW.name);
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_patient_insert
AFTER INSERT
ON Patients
FOR EACH ROW
BEGIN
    INSERT INTO PatientAudit(patient_name,action_type)
    VALUES(NEW.name,'INSERT');
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER before_patient_update
BEFORE UPDATE
ON Patients
FOR EACH ROW
BEGIN
    SET NEW.address=UPPER(NEW.address);
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER after_patient_update
AFTER UPDATE
ON Patients
FOR EACH ROW
BEGIN
    INSERT INTO PatientAudit(patient_name,action_type)
    VALUES(NEW.name,'UPDATE');
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER before_patient_delete
BEFORE DELETE
ON Patients
FOR EACH ROW
BEGIN
    INSERT INTO PatientAudit(patient_name,action_type)
    VALUES(OLD.name,'DELETE');
END//

DELIMITER ;

UPDATE Patients
SET address='Mumbai'
WHERE patient_id=1;

DELETE FROM Patients
WHERE patient_id=4;

SELECT * FROM PatientAudit;