package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.AddressDao;
import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.model.Address;
import edu.miu.cs489.dentalappointment.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;
    private ModelMapper modelMapper;

    public AddressServiceImpl(AddressDao addressDao, ModelMapper modelMapper) {
        this.addressDao = addressDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Address add(Address address) {
        return addressDao.save(address);
    }

    @Override
    public List<AddressDto> getAll() {
        return addressDao.findAll()
                .stream()
                .map(a -> modelMapper.map(a, AddressDto.class))
                .toList();
    }

    @Override
    public Optional<Address> get(Integer id) {
        return addressDao.findById(id);
    }

    @Override
    public void update(Integer id, Address address) {
        Optional<Address> temp = addressDao.findById(id);
        if (temp.isPresent()) {
            Address existing = temp.get();
            existing.setCity(address.getCity());
            existing.setState(address.getState());
            existing.setStreet(address.getStreet());
            existing.setZip(address.getZip());

            addressDao.save(existing);
        }
    }

    @Override
    public void delete(Integer id) {
        addressDao.deleteById(id);
    }
}
