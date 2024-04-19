package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.AddressDao;
import edu.miu.cs489.dentalappointment.dto.AddressDto;
import edu.miu.cs489.dentalappointment.dto.AddressDto2;
import edu.miu.cs489.dentalappointment.exception.AddressNotFoundException;
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
    public AddressDto add(AddressDto address) {
        Address savedAddress = addressDao.save(modelMapper.map(address, Address.class));
        return modelMapper.map(savedAddress, AddressDto.class);
    }

    @Override
    public List<AddressDto2> getAll() {
        return addressDao.findAll()
                .stream()
                .map(a -> modelMapper.map(a, AddressDto2.class))
                .toList();
    }

    @Override
    public AddressDto2 get(Integer id) throws AddressNotFoundException {
        return modelMapper.map(addressDao.findById(id).orElseThrow(
                () -> new AddressNotFoundException(String.format("address with ID, %d, is not found", id))),
                AddressDto2.class);
    }

    @Override
    public AddressDto update(Integer id, AddressDto address) throws AddressNotFoundException {
        Optional<Address> temp = addressDao.findById(id);
        if (temp.isPresent()) {
            Address existing = temp.get();
            existing.setCity(address.getCity());
            existing.setState(address.getState());
            existing.setStreet(address.getStreet());
            existing.setZip(address.getZip());

            addressDao.save(existing);

            return modelMapper.map(existing, AddressDto.class);
        } else {
            throw new AddressNotFoundException(String.format("address with ID, %d, is not found", id));
        }
    }

    @Override
    public void delete(Integer id) {
        addressDao.deleteById(id);
    }
}
