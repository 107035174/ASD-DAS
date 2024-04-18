package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.DentistDao;
import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.exception.DentistNotFoundException;
import edu.miu.cs489.dentalappointment.model.Dentist;
import edu.miu.cs489.dentalappointment.service.DentistService;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistDao dentistDao;
    private ModelMapper modelMapper;

    public DentistServiceImpl(DentistDao dentistDao, ModelMapper modelMapper) {
        this.dentistDao = dentistDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DentistDto add(DentistDto dentist) {
        Dentist savedDentist = dentistDao.save(modelMapper.map(dentist, Dentist.class));
        return modelMapper.map(savedDentist, DentistDto.class);
    }

    @Override
    public List<DentistDto> getAll() {
        return dentistDao.findAll()
                .stream().map(d -> modelMapper.map(d, DentistDto.class))
                .toList();
    }

    @Override
    public Dentist get(Integer id) throws DentistNotFoundException {
        return dentistDao.findById(id).orElseThrow(
                () -> new DentistNotFoundException(String.format("Dentist with ID, %d, is not found", id)));
    }

    @Override
    public DentistDto update(Integer id, DentistDto dentist) throws DentistNotFoundException {
        Optional<Dentist> temp = dentistDao.findById(id);
        if (temp.isPresent()) {
            Dentist existing = temp.get();

            existing.setFirstName(dentist.getFirstName());
            existing.setLastName(dentist.getLastName());
            existing.setPhoneNumber(dentist.getPhoneNumber());
            existing.setEmail(dentist.getEmail());
            existing.setSpecialization(dentist.getSpecialization());

            dentistDao.save(existing);

            return modelMapper.map(existing, DentistDto.class);
        } else
            throw new DentistNotFoundException(String.format("Dentist with ID, %d, is not found", id));
    }

    @Override
    public void delete(Integer id) {
        dentistDao.deleteById(id);
    }

}
