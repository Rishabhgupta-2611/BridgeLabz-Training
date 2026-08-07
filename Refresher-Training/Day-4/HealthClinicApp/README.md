# 🏥 Health Clinic Management System (`HealthClinicApp`)

A robust, multi-layered Java & MySQL console application built using JDBC (Java Database Connectivity) to manage core healthcare clinic operations, including patient registration, doctor records, appointment scheduling, transactional billing, clinical visit histories, and automated database auditing.

---

## 🌟 Key Features

* **👨‍⚕️ Doctor & Patient Management**
  * Register new patients with demographic details (Name, DOB, Gender, Phone, Email, Active Status).
  * Register doctors and map their specializations.
  * Retrieve and view active patients and doctors.

* **📅 Appointment Lifecycle Management**
  * Book appointment slots between patients and doctors with date and time scheduling.
  * View scheduled, completed, or cancelled appointments.
  * Search and track appointment statuses.

* **💳 Transactional Billing & Visit History**
  * Complete appointments with diagnosis, prescription, visit notes, and bill creation.
  * Uses **ACID-compliant JDBC Transactions** (`setAutoCommit(false)`, `commit()`, `rollback()`) to atomically update appointment statuses while concurrently creating billing records and visit logs.

* **📊 Automated Database Auditing**
  * Database-level triggers (`trg_appointment_audit_insert`, `trg_appointment_audit_update`) automatically record all insert and update events on appointments in an `audit_log` table.

* **🔒 Principle of Least Privilege Security**
  * Dedicated application user setup (`clinic_app_user`) with scoped permissions (`SELECT`, `INSERT`, `UPDATE`, `DELETE`) on the database.

---

## 🏗️ Architecture & Technology Stack

### Tech Stack
* **Language:** Java 21
* **Database:** MySQL 8.0+
* **Connectivity:** JDBC (`mysql-connector-j` 9.3.0)
* **Build Tool:** Apache Maven 3.8+

### Architectural Pattern
The application strictly adheres to the **Layered Architecture (N-Tier)** design pattern:

```
┌─────────────────────────────────────────────────────────────┐
│                    Presentation (UI)                        │
│                     [ConsoleMenu.java]                      │
└──────────────────────────────┬──────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────┐
│                      Service Layer                          │
│                [AppointmentService.java]                    │
└──────────────────────────────┬──────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────┐
│                        DAO Layer                            │
│ [PatientDAO, DoctorDAO, AppointmentDAO, BillingDAO, DAOImpl]│
└──────────────────────────────┬──────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────┐
│                    Model / DTO Layer                        │
│ [Patient, Doctor, Appointment, Billing, VisitHistory, etc.] │
└──────────────────────────────┬──────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────┐
│                Database & Config Layer                      │
│     [DatabaseConnection.java] ──► [MySQL Server]            │
└─────────────────────────────────────────────────────────────┘
```

---

## 📂 Project Structure

```
HealthClinicApp/
├── database/
│   └── health_clinic_schema.sql  # Complete DDL, DML, triggers, indexes & audit table
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── clinic/
│   │               ├── Main.java                 # Application Entry Point
│   │               ├── TestConnection.java       # Database Connectivity Verification
│   │               ├── config/
│   │               │   └── DatabaseConnection.java# JDBC DriverManager Configuration
│   │               ├── dao/                      # Data Access Object Interfaces & Implementation
│   │               │   ├── AppointmentDAO.java
│   │               │   ├── AppointmentDAOImpl.java
│   │               │   ├── BillingDAO.java
│   │               │   ├── BillingDAOImpl.java
│   │               │   ├── DoctorDAO.java
│   │               │   ├── DoctorDAOImpl.java
│   │               │   ├── DoctorSpecializationDAO.java
│   │               │   ├── DoctorSpecializationDAOImpl.java
│   │               │   ├── PatientDAO.java
│   │               │   ├── PatientDAOImpl.java
│   │               │   ├── SpecializationDAO.java
│   │               │   ├── SpecializationDAOImpl.java
│   │               │   ├── VisitHistoryDAO.java
│   │               │   └── VisitHistoryDAOImpl.java
│   │               ├── dto/                      # Data Transfer Objects / Entities
│   │               │   ├── Appointment.java
│   │               │   ├── Billing.java
│   │               │   ├── Doctor.java
│   │               │   ├── Patient.java
│   │               │   ├── Specialization.java
│   │               │   └── VisitHistory.java
│   │               ├── service/
│   │               │   └── AppointmentService.java# Transactional Business Logic
│   │               └── ui/
│   │                   └── ConsoleMenu.java      # Interactive CLI User Interface
├── pom.xml                                       # Maven Project Descriptor & Dependencies
└── README.md                                     # Project Documentation
```

---

## 🗄️ Database Schema Overview

The database schema (`health_clinic_app_db`) consists of 8 interconnected tables designed with proper constraints, foreign keys, and indexes:

| Table Name | Description | Key Relationships |
| :--- | :--- | :--- |
| `patients` | Stores patient records and contact information | Primary Key: `patient_id` |
| `doctors` | Stores doctor credentials and contact details | Primary Key: `doctor_id` |
| `specializations` | Catalog of medical specializations | Primary Key: `specialization_id` |
| `doctor_specializations` | Many-to-Many junction table for doctors & specializations | FKs: `doctor_id`, `specialization_id` |
| `appointments` | Transactional table linking patients, doctors, & slots | FKs: `patient_id`, `doctor_id` |
| `billing` | Financial invoices tied 1:1 to appointments | FK: `appointment_id` (Unique) |
| `visit_history` | Medical diagnosis, prescriptions, and notes | FK: `appointment_id` (Unique) |
| `audit_log` | Tracks database change history generated via MySQL triggers | Stores `table_name`, `action`, `record_id` |

---

## 🚀 Getting Started & Setup Guide

### 1. Prerequisites
Ensure you have the following installed on your machine:
* Java Development Kit (JDK 21 or higher)
* Apache Maven (3.8+)
* MySQL Server (8.0+)

### 2. Database Setup
1. Open MySQL Workbench, MySQL Shell, or your preferred SQL CLI.
2. Execute the initialization script located in `database/health_clinic_schema.sql`:
   ```bash
   mysql -u root -p < database/health_clinic_schema.sql
   ```
3. Verify that `health_clinic_app_db` was created successfully along with sample data.

### 3. Database Credentials Configuration
Update the database connection details in [`DatabaseConnection.java`](file:///d:/BridgeLabz-Training/Refresher-Training/Day-4/HealthClinicApp/src/main/java/com/clinic/config/DatabaseConnection.java) to match your local MySQL configuration:

```java
private static final String URL = "jdbc:mysql://localhost:3306/health_clinic_app_db";
private static final String USER = "root";       // Or your MySQL username
private static final String PASSWORD = "your_password"; // Replace with your MySQL password
```

---

## ⚙️ Building & Running the Application

### 1. Test Database Connection
To test if your JDBC configuration connects to your MySQL server:
```bash
mvn exec:java -Dexec.mainClass="com.clinic.TestConnection"
```

### 2. Build the Project
Compile the project source files using Maven:
```bash
mvn clean compile
```

### 3. Run the Main Console Application
Launch the main application:
```bash
mvn exec:java -Dexec.mainClass="com.clinic.Main"
```

---

## 🖥️ Console Menu Interface

When launched, the application displays an interactive command-line interface:

```text
===== HEALTH CLINIC MANAGEMENT SYSTEM =====
1. Add Patient
2. View Patients
3. Add Doctor
4. View Doctors
5. Book Appointment
6. View Appointments
7. Complete Appointment
8. View Bills
9. Exit
Enter Choice : 
```

### Key Workflows:
1. **Adding Patients/Doctors**: Prompted input for contact details and medical attributes.
2. **Booking Appointments**: Requires valid `Patient ID`, `Doctor ID`, and date string in `yyyy-MM-dd HH:mm:ss` format.
3. **Completing Appointments**: Selecting an appointment ID triggers prompt for diagnosis, prescription, notes, and billing amount. The system executes a multi-statement transaction to update status to `Completed` and insert corresponding `billing` and `visit_history` entries.

---

## 🔄 Transaction & Audit Architecture

### Transaction Management (`AppointmentService.java`)
When completing an appointment, the system executes atomic multi-table operations:
```java
con = DatabaseConnection.getConnection();
con.setAutoCommit(false); // Begin Transaction

// 1. Update appointment status to 'Completed'
// 2. Insert billing record (Amount, Payment Status)
// 3. Insert visit history (Diagnosis, Prescription, Notes)

con.commit(); // Commit Transaction on Success
```
If any error occurs during execution, `con.rollback()` is invoked in the catch block to maintain database consistency.

### Audit Triggers (`health_clinic_schema.sql`)
Triggers automatically track mutation events on the `appointments` table:
* `trg_appointment_audit_insert`: Logs `INSERT` actions.
* `trg_appointment_audit_update`: Logs `UPDATE` actions.

---

## 📄 License
This project is developed as part of the BridgeLabz Training Refresher Program.
