package com.hibernate.demo.controller;

import com.hibernate.demo.entity.Address;
import com.hibernate.demo.repository.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("address")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/show")
    @ResponseBody
    public List<Address> show(){
        return addressRepository.findAll();
    }
}
