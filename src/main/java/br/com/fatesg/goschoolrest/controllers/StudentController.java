package br.com.fatesg.goschoolrest.controllers;

import br.com.fatesg.goschoolrest.interfaces.GenericOperations;
import br.com.fatesg.goschoolrest.models.Student;
import br.com.fatesg.goschoolrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController implements GenericOperations<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Student post(@RequestBody Student entity) {
        return studentService.post(entity);
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public List<Student> get() {
        return studentService.get();
    }

    @Override
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public void put(@RequestBody Student entity) {
        studentService.put(entity);
    }

    @Override
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public void delete(@RequestBody Student entity) {
        studentService.delete(entity);
    }

}
