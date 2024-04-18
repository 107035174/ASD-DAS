package edu.miu.cs489.dentalappointment.service;

import java.util.List;

import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.exception.SurgeryNotFoundException;
import edu.miu.cs489.dentalappointment.model.Surgery;

public interface SurgeryService {
    public SurgeryDto add(SurgeryDto surgery);

    public List<SurgeryDto> getAll();

    public Surgery get(Integer id) throws SurgeryNotFoundException;

    public SurgeryDto update(Integer id, SurgeryDto surgery) throws SurgeryNotFoundException;

    public void delete(Integer id);
}
