package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.AddressRequest;
import com.jhansi.ecommerce.entity.Address;
import com.jhansi.ecommerce.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(
            AddressService addressService) {

        this.addressService = addressService;
    }

    @PostMapping
    public Address addAddress(
            @RequestBody AddressRequest request) {

        return addressService.addAddress(request);
    }

    @GetMapping("/user/{userId}")
    public List<Address> getAddressesByUserId(
            @PathVariable Long userId) {

        return addressService.getAddressesByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(
            @PathVariable Long id) {

        addressService.deleteAddress(id);

        return "Address Deleted Successfully";
    }
}