package com.hibernate.demo.service;

import com.hibernate.demo.entity.Student;
import com.hibernate.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> findAll(){
        return repository.findAll();
    }

    @Override
    public List<Student> findByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }
}
