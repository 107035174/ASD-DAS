package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.dto.DentistDto2;
import edu.miu.cs489.dentalappointment.exception.DentistNotFoundException;

public interface DentistService {
    public DentistDto2 add(DentistDto2 dentist);

    public List<DentistDto> getAll();

    public DentistDto get(Integer id) throws DentistNotFoundException;

    public DentistDto update(Integer id, DentistDto dentist) throws DentistNotFoundException;

    public void delete(Integer id);
}
