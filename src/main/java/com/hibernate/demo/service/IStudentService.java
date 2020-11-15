package com.hibernate.demo.service;

import com.hibernate.demo.entity.Student;

import java.util.List;

public interface IStudentService {

    void save(Student student);
    List<Student> findAll();
    List<Student> findByFirstName(String firstName);

}
