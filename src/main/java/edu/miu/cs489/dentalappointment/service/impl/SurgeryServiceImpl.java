package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.SurgeryDao;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto2;
import edu.miu.cs489.dentalappointment.exception.SurgeryNotFoundException;
import edu.miu.cs489.dentalappointment.model.Address;
import edu.miu.cs489.dentalappointment.model.Surgery;
import edu.miu.cs489.dentalappointment.service.SurgeryService;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryDao surgeryDao;
    private ModelMapper modelMapper;

    public SurgeryServiceImpl(SurgeryDao surgeryDao, ModelMapper modelMapper) {
        this.surgeryDao = surgeryDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public SurgeryDto2 add(SurgeryDto2 surgery) {
        Address address = modelMapper.map(surgery.getAddress(), Address.class);
        Surgery savedSurgery = modelMapper.map(surgery, Surgery.class);
        savedSurgery.setAddress(address);
        surgeryDao.save(savedSurgery);
        return modelMapper.map(savedSurgery, SurgeryDto2.class);
    }

    @Override
    public List<SurgeryDto> getAll() {
        return surgeryDao.findAll()
                .stream().map(s -> modelMapper.map(s, SurgeryDto.class)).toList();
    }

    @Override
    public SurgeryDto get(Integer id) throws SurgeryNotFoundException {
        return modelMapper.map(surgeryDao.findById(id).orElseThrow(
                () -> new SurgeryNotFoundException(String.format("Surgery with ID, %d, is not found", id))),
                SurgeryDto.class);
    }

    @Override
    public SurgeryDto update(Integer id, SurgeryDto surgery) throws SurgeryNotFoundException {
        Optional<Surgery> temp = surgeryDao.findById(id);
        if (temp.isPresent()) {
            Surgery existing = temp.get();

            existing.setName(surgery.getName());
            existing.setPhoneNumber(surgery.getPhoneNumber());
            existing.setAddress(modelMapper.map(surgery.getAddress(), Address.class));

            surgeryDao.save(existing);

            return modelMapper.map(existing, SurgeryDto.class);
        } else
            throw new SurgeryNotFoundException(String.format("Surgery with ID, %d, is not found", id));
    }

    @Override
    public void delete(Integer id) {
        surgeryDao.deleteById(id);
    }
}
