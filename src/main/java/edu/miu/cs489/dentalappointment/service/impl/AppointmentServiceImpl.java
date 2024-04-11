package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dao.AppointmentDao;
import edu.miu.cs489.dentalappointment.model.Appointment;
import edu.miu.cs489.dentalappointment.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDao appointmentDao;

    AppointmentServiceImpl(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public Appointment add(Appointment appointment) {
        return appointmentDao.save(appointment);
    }

    public List<Appointment> addAll(List<Appointment> appointments) {
        return appointmentDao.saveAll(appointments);
    }

    public Optional<Appointment> get(Integer id) {
        return appointmentDao.findById(id);
    }

    public void update(Integer id, Appointment appointment) {
        Optional<Appointment> temp = get(id);
        if (temp.isPresent()) {
            Appointment existing = temp.get();
            existing.setScheduledDate(appointment.getScheduledDate());
            existing.setDentist(appointment.getDentist());
            existing.setPatient(appointment.getPatient());
            existing.setSurgery(appointment.getSurgery());

            appointmentDao.save(existing);
        }
    }
}
