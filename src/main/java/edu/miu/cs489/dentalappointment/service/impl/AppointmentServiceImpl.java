package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.AppointmentDao;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto;
import edu.miu.cs489.dentalappointment.model.Appointment;
import edu.miu.cs489.dentalappointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDao appointmentDao;
    private ModelMapper modelMapper;

    AppointmentServiceImpl(AppointmentDao appointmentDao, ModelMapper modelMapper) {
        this.appointmentDao = appointmentDao;
        this.modelMapper = modelMapper;
    }

    public Appointment add(Appointment appointment) {
        return appointmentDao.save(appointment);
    }

    public List<AppointmentDto> getAll() {
        return appointmentDao.findAll().stream()
                .map(app -> modelMapper.map(app, AppointmentDto.class))
                .toList();
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

    public void delete(Integer id) {
        appointmentDao.deleteById(id);
    }
}
