package br.com.fatesg.goschoolrest.services;

import br.com.fatesg.goschoolrest.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private StudentService studentService;

    public List<Student> getStudentsRoute() {
        List<Student> students = studentService.getAll();
        return students;
    }

}
