package com.clinic.dao;

import java.util.List;
import com.clinic.dto.Billing;

public interface BillingDAO {

    int generateBill(Billing billing);

    Billing getBillById(int billId);

    Billing getBillByAppointmentId(int appointmentId);

    List<Billing> getAllBills();

    boolean updateBill(Billing billing);

    boolean deleteBill(int billId);

}