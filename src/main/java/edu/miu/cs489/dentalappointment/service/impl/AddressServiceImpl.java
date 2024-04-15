package edu.miu.cs489.dentalappointment.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.cs489.dentalappointment.dao.AddressDao;
import edu.miu.cs489.dentalappointment.dto.AddressDto;
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
        return new AddressDto(savedAddress.getAddressId(), savedAddress.getStreet(), savedAddress.getCity(),
                savedAddress.getState(), savedAddress.getZip());
    }

    @Override
    public List<AddressDto> getAll() {
        return addressDao.findAll()
                .stream()
                .map(a -> modelMapper.map(a, AddressDto.class))
                .toList();
    }

    @Override
    public Address get(Integer id) throws AddressNotFoundException {
        return addressDao.findById(id).orElseThrow(
                () -> new AddressNotFoundException(String.format("address with ID, %d, is not found", id)));
    }

    @Override
    public Address update(Integer id, Address address) throws AddressNotFoundException{
        Optional<Address> temp = addressDao.findById(id);
        if (temp.isPresent()) {
            Address existing = temp.get();
            existing.setCity(address.getCity());
            existing.setState(address.getState());
            existing.setStreet(address.getStreet());
            existing.setZip(address.getZip());

            return addressDao.save(existing);
        } else {
            throw new AddressNotFoundException(String.format("address with ID, %d, is not found", id));
        }
    }

    @Override
    public void delete(Integer id) {
        addressDao.deleteById(id);
    }
}
