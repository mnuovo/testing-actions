package com.hibernate.demo.controller;

import com.hibernate.demo.entity.Address;
import com.hibernate.demo.entity.Student;
import com.hibernate.demo.repository.AddressRepository;
import com.hibernate.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    private final AddressRepository addressRepository;
    private final StudentService studentService;

    public StudentController(AddressRepository addressRepository, StudentService studentService) {
        this.addressRepository = addressRepository;
        this.studentService = studentService;
    }

    @GetMapping("/add")
    @ResponseBody
    public Student addStudent(){

        Student student = new Student();
        student.setFirstName("Michele");
        student.setLastName("Nuovo");
        student.setEmail("michele.nuovo.sky@gmail.com");
        student.setPhoneNumber("+420 601 359 665");

        Address address = new Address();
        address.setCountryCode("0100");
        address.setStateCode("9090");
        address.setStreet("Via Delle Cinciarelle");
        address.setStudent(student);

        student.setAddress(address);

        studentService.save(student);
        addressRepository.save(address);

        return student;
    }

    @GetMapping("/show")
    @ResponseBody
    public List<Student> showStudents(){
        return studentService.findAll();
    }

    @GetMapping("show/{name}")
    @ResponseBody
    public Student showStudent(@PathVariable String name){
        return studentService.findByFirstName(name).get(0);

    }


}
