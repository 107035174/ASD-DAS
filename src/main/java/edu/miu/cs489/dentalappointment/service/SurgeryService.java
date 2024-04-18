package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto2;
import edu.miu.cs489.dentalappointment.exception.SurgeryNotFoundException;

public interface SurgeryService {
    public SurgeryDto2 add(SurgeryDto2 surgery);

    public List<SurgeryDto> getAll();

    public SurgeryDto get(Integer id) throws SurgeryNotFoundException;

    public SurgeryDto update(Integer id, SurgeryDto surgery) throws SurgeryNotFoundException;

    public void delete(Integer id);
}
