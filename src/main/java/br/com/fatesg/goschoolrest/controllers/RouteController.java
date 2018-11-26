package br.com.fatesg.goschoolrest.controllers;

import br.com.fatesg.goschoolrest.models.Student;
import br.com.fatesg.goschoolrest.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        List<Student> students = routeService.getStudentsRoute();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
