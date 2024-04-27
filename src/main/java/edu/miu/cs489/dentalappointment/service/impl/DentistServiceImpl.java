package edu.miu.cs489.dentalappointment.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.DentistDao;
import edu.miu.cs489.dentalappointment.dao.RoleDao;
import edu.miu.cs489.dentalappointment.dto.DentistDto;
import edu.miu.cs489.dentalappointment.dto.DentistDto2;
import edu.miu.cs489.dentalappointment.exception.DentistNotFoundException;
import edu.miu.cs489.dentalappointment.model.Dentist;
import edu.miu.cs489.dentalappointment.model.Role;
import edu.miu.cs489.dentalappointment.service.DentistService;
import jakarta.transaction.Transactional;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistDao dentistDao;
    private ModelMapper modelMapper;
    private RoleDao roleDao;

    public DentistServiceImpl(DentistDao dentistDao, ModelMapper modelMapper, RoleDao roleDao) {
        this.dentistDao = dentistDao;
        this.modelMapper = modelMapper;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public DentistDto2 add(DentistDto2 dentist) {
        Role dentistRole = roleDao.findByRoleName("DENTIST")
                .orElseThrow(() -> new RuntimeException("Patient role not found"));
        Dentist savedDentist = dentistDao.save(modelMapper.map(dentist, Dentist.class));
        savedDentist.setRoles(Arrays.asList(dentistRole));
        return modelMapper.map(savedDentist, DentistDto2.class);
    }

    @Override
    public List<DentistDto> getAll() {
        return dentistDao.findAll()
                .stream().map(d -> modelMapper.map(d, DentistDto.class))
                .toList();
    }

    @Override
    public DentistDto get(Integer id) throws DentistNotFoundException {
        return modelMapper.map(dentistDao.findById(id).orElseThrow(
                () -> new DentistNotFoundException(String.format("Dentist with ID, %d, is not found", id))),
                DentistDto.class);
    }

    @Transactional
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

    @Transactional
    @Override
    public void delete(Integer id) {
        dentistDao.deleteById(id);
    }

}
