package br.com.fatesg.goschoolrest.services;

import br.com.fatesg.goschoolrest.interfaces.GenericOperations;
import br.com.fatesg.goschoolrest.models.Student;
import br.com.fatesg.goschoolrest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements GenericOperations<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student post(Student entity) {
        Student student = studentRepository.save(entity);
        return student;
    }

    @Override
    public List<Student> get() {
        return studentRepository.findAll();
    }

    @Override
    public void put(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void delete(Student entity) {
        studentRepository.delete(entity);
    }

}
