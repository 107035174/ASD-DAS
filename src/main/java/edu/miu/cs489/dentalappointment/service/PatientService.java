package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.PatientDto;
import edu.miu.cs489.dentalappointment.dto.PatientDto2;
import edu.miu.cs489.dentalappointment.exception.PatientNotFoundException;

public interface PatientService {
    public PatientDto2 add(PatientDto2 patient);

    public List<PatientDto> getAll();

    public PatientDto get(Integer id) throws PatientNotFoundException;

    public PatientDto update(Integer id, PatientDto patient) throws PatientNotFoundException;

    public void delete(Integer id);
}
