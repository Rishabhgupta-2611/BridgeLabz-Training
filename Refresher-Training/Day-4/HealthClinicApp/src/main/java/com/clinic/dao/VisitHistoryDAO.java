package com.clinic.dao;

import java.util.List;
import com.clinic.dto.VisitHistory;

public interface VisitHistoryDAO {

    int addVisitHistory(VisitHistory visitHistory);

    VisitHistory getVisitHistoryById(int visitId);

    VisitHistory getVisitHistoryByAppointmentId(int appointmentId);

    List<VisitHistory> getAllVisitHistory();

    boolean updateVisitHistory(VisitHistory visitHistory);

    boolean deleteVisitHistory(int visitId);

}