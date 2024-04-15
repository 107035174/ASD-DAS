package edu.miu.cs489.dentalappointment.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.model.Surgery;

public interface SurgeryService {
    public Surgery add(Surgery surgery);

    public List<SurgeryDto> getAll();

    public Optional<Surgery> get(Integer id);

    public void update(Integer id, Surgery surgery);

    public void delete(Integer id);
}
