package br.com.fatesg.goschoolrest.controllers;

import br.com.fatesg.goschoolrest.models.ErrorDetails;
import br.com.fatesg.goschoolrest.models.Student;
import br.com.fatesg.goschoolrest.services.StudentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    private ErrorDetails errorDetails;

    @PostMapping()
    public ResponseEntity<Object> post(@Valid @RequestBody Student entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            this.errorDetails = new ErrorDetails(bindingResult);
            return new ResponseEntity<>(this.errorDetails, HttpStatus.BAD_REQUEST);
        }
        Student student = null;
        try {
            student = studentService.post(entity);
        } catch (JSONException e) {
            e.printStackTrace();
            this.errorDetails = new ErrorDetails("Could not get the coordinates with the address provided.");
            return new ResponseEntity<>(this.errorDetails, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Student student = studentService.getById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            this.errorDetails = new ErrorDetails(e.getMessage());
            return new ResponseEntity<>(this.errorDetails, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Object> put(@Valid @RequestBody Student entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            this.errorDetails = new ErrorDetails(bindingResult);
            return new ResponseEntity<>(this.errorDetails, HttpStatus.BAD_REQUEST);
        }

        try {
            studentService.put(entity);
        } catch (JSONException e) {
            e.printStackTrace();
            this.errorDetails = new ErrorDetails("Could not get the coordinates with the address provided.");
            return new ResponseEntity<>(this.errorDetails, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
