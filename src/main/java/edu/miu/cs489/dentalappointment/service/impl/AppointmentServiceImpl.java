package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.AppointmentDao;
import edu.miu.cs489.dentalappointment.dao.DentistDao;
import edu.miu.cs489.dentalappointment.dao.PatientDao;
import edu.miu.cs489.dentalappointment.dao.SurgeryDao;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto;
import edu.miu.cs489.dentalappointment.dto.AppointmentDto2;
import edu.miu.cs489.dentalappointment.exception.AppointmentNotFoundException;
import edu.miu.cs489.dentalappointment.model.Appointment;
import edu.miu.cs489.dentalappointment.model.Dentist;
import edu.miu.cs489.dentalappointment.model.Patient;
import edu.miu.cs489.dentalappointment.model.Surgery;
import edu.miu.cs489.dentalappointment.service.AppointmentService;
import jakarta.transaction.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDao appointmentDao;
    private DentistDao dentistDao;
    private PatientDao patientDao;
    private SurgeryDao surgeryDao;
    private ModelMapper modelMapper;

    public AppointmentServiceImpl(AppointmentDao appointmentDao, DentistDao dentistDao, PatientDao patientDao,
            SurgeryDao surgeryDao, ModelMapper modelMapper) {
        this.appointmentDao = appointmentDao;
        this.dentistDao = dentistDao;
        this.patientDao = patientDao;
        this.surgeryDao = surgeryDao;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public AppointmentDto add(AppointmentDto2 appointment) {
        Appointment savedAppointment = appointmentDao.save(modelMapper.map(appointment, Appointment.class));
        return modelMapper.map(savedAppointment, AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getAll() {
        return appointmentDao.findAll().stream()
                .map(app -> modelMapper.map(app, AppointmentDto.class))
                .toList();
    }

    @Override
    public Appointment get(Integer id) throws AppointmentNotFoundException {
        return appointmentDao.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(
                        String.format("Appointment with ID, %d, is not found", id)));
    }

    @Transactional
    @Override
    public AppointmentDto2 update(Integer id, AppointmentDto2 appointment)
            throws AppointmentNotFoundException, RuntimeException {
        Optional<Appointment> temp = appointmentDao.findById(id);
        if (temp.isPresent()) {
            Appointment existing = temp.get();

            if (appointment.getDentist() != null) {
                Integer dentistId = appointment.getDentist().getUserId();
                Dentist dentist = dentistDao.findById(dentistId)
                        .orElseThrow(() -> new RuntimeException(
                                String.format("Dentist with ID, %d, is not found", dentistId)));
                existing.setDentist(dentist);
            }

            if (appointment.getPatient() != null) {
                Integer patientId = appointment.getPatient().getUserId();
                Patient patient = patientDao.findById(patientId)
                        .orElseThrow(() -> new RuntimeException(
                                String.format("Patient with ID, %d, is not found", patientId)));
                existing.setPatient(patient);
            }

            if (appointment.getSurgery() != null) {
                Integer surgeryId = appointment.getSurgery().getSurgeryId();
                Surgery surgery = surgeryDao.findById(surgeryId)
                        .orElseThrow(() -> new RuntimeException(
                                String.format("Surgery with ID, %d, is not found", surgeryId)));
                existing.setSurgery(surgery);
            }

            existing.setScheduledDateTime(appointment.getScheduledDateTime());

            appointmentDao.save(existing);

            return modelMapper.map(existing, AppointmentDto2.class);
        } else {
            throw new AppointmentNotFoundException(String.format("Appointment with ID, %d, is not found", id));
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        appointmentDao.deleteById(id);
    }
}
