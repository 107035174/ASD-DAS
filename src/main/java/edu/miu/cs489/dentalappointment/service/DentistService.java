package edu.miu.cs489.dentalappointment.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs489.dentalappointment.model.Dentist;

public interface DentistService {
    public Dentist add(Dentist dentist);

    public List<Dentist> getAll();

    public Optional<Dentist> get(Integer id);

    public void update(Integer id, Dentist dentist);

    public void delete(Integer id);
}
