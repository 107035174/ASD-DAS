package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.SurgeryDao;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
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
    public SurgeryDto add(SurgeryDto surgery) {
        Surgery savedSurgery = surgeryDao.save(modelMapper.map(surgery, Surgery.class));
        return modelMapper.map(savedSurgery, SurgeryDto.class);
    }

    @Override
    public List<SurgeryDto> getAll() {
        return surgeryDao.findAll()
                .stream().map(s -> modelMapper.map(s, SurgeryDto.class)).toList();
    }

    @Override
    public Surgery get(Integer id) throws SurgeryNotFoundException {
        return surgeryDao.findById(id).orElseThrow(
                () -> new SurgeryNotFoundException(String.format("Surgery with ID, %d, is not found", id)));
    }

    @Override
    public SurgeryDto update(Integer id, SurgeryDto surgery) throws SurgeryNotFoundException {
        Optional<Surgery> temp = surgeryDao.findById(id);
        if (temp.isPresent()) {
            Surgery existing = temp.get();

            existing.setName(surgery.name());
            existing.setPhoneNumber(surgery.phoneNumber());
            existing.setAddress(modelMapper.map(surgery.address(), Address.class));

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
