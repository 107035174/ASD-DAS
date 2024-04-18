package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.PatientDao;
import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.exception.PatientNotFoundException;
import edu.miu.cs489.dentalappointment.model.Address;
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
    public PatientDto add(PatientDto patient) {
        Patient savedPatient = patientDao.save(modelMapper.map(patient, Patient.class));
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getAll() {
        return patientDao.findAll()
                .stream().map(p -> modelMapper.map(p, PatientDto.class)).toList();
    }

    @Override
    public Patient get(Integer id) throws PatientNotFoundException {
        return patientDao.findById(id).orElseThrow(
                () -> new PatientNotFoundException(String.format("Patient with ID, %d, is not found", id)));
    }

    @Override
    public PatientDto update(Integer id, PatientDto patient) throws PatientNotFoundException {
        Optional<Patient> temp = patientDao.findById(id);
        if (temp.isPresent()) {
            Patient existing = temp.get();

            existing.setFirstName(patient.firstName());
            existing.setLastName(patient.lastName());
            existing.setMailingAddress(modelMapper.map(patient.mailingAddress(), Address.class));
            existing.setPhoneNumber(patient.phoneNumber());
            existing.setEmail(patient.email());
            existing.setDob(patient.dob());

            patientDao.save(existing);

            return modelMapper.map(existing, PatientDto.class);
        } else
            throw new PatientNotFoundException(String.format("Patient with ID, %d, is not found", id));
    }

    @Override
    public void delete(Integer id) {
        patientDao.deleteById(id);
    }

}
