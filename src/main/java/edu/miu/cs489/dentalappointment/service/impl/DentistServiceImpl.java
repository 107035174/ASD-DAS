package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.DentistDao;
import edu.miu.cs489.dentalappointment.dto.DentistDto;
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
    public Dentist add(Dentist dentist) {
        return dentistDao.save(dentist);
    }

    @Override
    public List<DentistDto> getAll() {
        return dentistDao.findAll()
                .stream().map(d -> modelMapper.map(d, DentistDto.class))
                .toList();
    }

    @Override
    public Optional<Dentist> get(Integer id) {
        return dentistDao.findById(id);
    }

    @Override
    public void update(Integer id, Dentist dentist) {
        Optional<Dentist> temp = dentistDao.findById(id);
        if (temp.isPresent()) {
            Dentist existing = temp.get();

            existing.setAppointments(dentist.getAppointments());
            existing.setEmail(dentist.getEmail());
            existing.setFirstName(dentist.getFirstName());
            existing.setLastName(dentist.getLastName());
            existing.setPhoneNumber(dentist.getPhoneNumber());
            existing.setSpecialization(dentist.getSpecialization());

            dentistDao.save(existing);
        }
    }

    @Override
    public void delete(Integer id) {
        dentistDao.deleteById(id);
    }

}
