package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.exception.DentistNotFoundException;
import edu.miu.cs489.dentalappointment.model.Dentist;

public interface DentistService {
    public DentistDto add(DentistDto dentist);

    public List<DentistDto> getAll();

    public Dentist get(Integer id) throws DentistNotFoundException;

    public DentistDto update(Integer id, DentistDto dentist) throws DentistNotFoundException;

    public void delete(Integer id);
}
