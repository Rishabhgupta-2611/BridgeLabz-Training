package com.clinic.dao;

import java.util.List;
import com.clinic.dto.Appointment;

public interface AppointmentDAO {

    int bookAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAllAppointments();

    boolean updateAppointment(Appointment appointment);

    boolean cancelAppointment(int appointmentId);

}