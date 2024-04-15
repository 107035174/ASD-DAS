package edu.miu.cs489.dentalappointment.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.model.Patient;

public interface PatientService {
    public Patient add(Patient patient);

    public List<PatientDto> getAll();

    public Optional<Patient> get(Integer id);

    public void update(Integer id, Patient patient);

    public void delete(Integer id);
}
