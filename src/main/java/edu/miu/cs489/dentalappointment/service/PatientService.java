package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.exception.PatientNotFoundException;
import edu.miu.cs489.dentalappointment.model.Patient;

public interface PatientService {
    public PatientDto add(PatientDto patient);

    public List<PatientDto> getAll();

    public Patient get(Integer id) throws PatientNotFoundException;

    public PatientDto update(Integer id, PatientDto patient) throws PatientNotFoundException;

    public void delete(Integer id);
}
