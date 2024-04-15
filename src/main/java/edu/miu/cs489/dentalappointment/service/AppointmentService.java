package edu.miu.cs489.dentalappointment.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dto.AppointmentDto;
import edu.miu.cs489.dentalappointment.model.Appointment;

public interface AppointmentService {
    public Appointment add(Appointment appointment);

    public List<AppointmentDto> getAll();

    public Optional<Appointment> get(Integer id);

    public void update(Integer id, Appointment appointment);

    public void delete(Integer id);
}
