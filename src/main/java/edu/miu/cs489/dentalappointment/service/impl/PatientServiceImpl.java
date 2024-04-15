package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.PatientDao;
import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.model.Patient;
import edu.miu.cs489.dentalappointment.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;
    private ModelMapper modelMapper;

    public PatientServiceImpl(PatientDao patientDao, ModelMapper modelMapper) {
        this.patientDao = patientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Patient add(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public List<PatientDto> getAll() {
        return patientDao.findAll()
                .stream().map(p -> modelMapper.map(p, PatientDto.class)).toList();
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
