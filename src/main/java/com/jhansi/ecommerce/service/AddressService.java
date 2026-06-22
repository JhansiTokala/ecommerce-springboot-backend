package com.jhansi.ecommerce.service;

import com.jhansi.ecommerce.dto.AddressRequest;
import com.jhansi.ecommerce.entity.Address;
import com.jhansi.ecommerce.entity.User;
import com.jhansi.ecommerce.repository.AddressRepository;
import com.jhansi.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(
            AddressRepository addressRepository,
            UserRepository userRepository) {

        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public Address addAddress(AddressRequest request) {

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Address address = new Address();

        address.setUser(user);
        address.setFullName(request.getFullName());
        address.setMobile(request.getMobile());
        address.setAddressLine(request.getAddressLine());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setPincode(request.getPincode());

        return addressRepository.save(address);
    }

    public List<Address> getAddressesByUserId(Long userId) {

        return addressRepository.findByUserId(userId);
    }

    public void deleteAddress(Long id) {

        addressRepository.deleteById(id);
    }
}