package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.AppointmentDto;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto2;
import edu.miu.cs489.dentalappointment.exception.AppointmentNotFoundException;
import edu.miu.cs489.dentalappointment.model.Appointment;

public interface AppointmentService {
    public AppointmentDto add(AppointmentDto2 appointment);

    public List<AppointmentDto> getAll();

    public Appointment get(Integer id) throws AppointmentNotFoundException;

    public AppointmentDto2 update(Integer id, AppointmentDto2 appointment) throws AppointmentNotFoundException;

    public void delete(Integer id);
}
