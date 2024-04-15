package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.SurgeryDao;
import edu.miu.cs489.dentalappointment.dto.SurgeryDto;
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
    public Surgery add(Surgery surgery) {
        return surgeryDao.save(surgery);
    }

    @Override
    public List<SurgeryDto> getAll() {
        return surgeryDao.findAll()
                .stream().map(s -> modelMapper.map(s, SurgeryDto.class)).toList();
    }

    @Override
    public Optional<Surgery> get(Integer id) {
        return surgeryDao.findById(id);
    }

    @Override
    public void update(Integer id, Surgery surgery) {
        Optional<Surgery> temp = surgeryDao.findById(id);
        if (temp.isPresent()) {
            Surgery existing = temp.get();

            existing.setAddress(surgery.getAddress());
            existing.setAppointments(surgery.getAppointments());
            existing.setName(surgery.getName());
            existing.setPhoneNumber(surgery.getPhoneNumber());

            surgeryDao.save(existing);
        }
    }

    @Override
    public void delete(Integer id) {
        surgeryDao.deleteById(id);
    }
}
