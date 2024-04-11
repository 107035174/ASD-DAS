package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dao.PatientDao;
import edu.miu.cs489.dentalappointment.model.Patient;
import edu.miu.cs489.dentalappointment.service.PatientService;

public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Patient add(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public List<Patient> getAll(List<Patient> patients) {
        return patientDao.saveAll(patients);
    }

    @Override
    public Optional<Patient> get(Integer id) {
        return patientDao.findById(id);
    }

    @Override
    public void update(Integer id, Patient patient) {
        Optional<Patient> temp = patientDao.findById(id);
        if (temp.isPresent()) {
            Patient existing = temp.get();

            existing.setAppointments(patient.getAppointments());
            existing.setDob(patient.getDob());
            existing.setEmail(patient.getEmail());
            existing.setFirstName(patient.getFirstName());
            existing.setLastName(patient.getLastName());
            existing.setMailingAddress(patient.getMailingAddress());
            existing.setPhoneNumber(patient.getPhoneNumber());

            patientDao.save(existing);
        }
    }

    @Override
    public void delete(Integer id) {
        patientDao.deleteById(id);
    }

}
