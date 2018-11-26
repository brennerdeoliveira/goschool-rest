package br.com.fatesg.goschoolrest.services;

import br.com.fatesg.goschoolrest.models.Student;
import br.com.fatesg.goschoolrest.repositories.StudentRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student post(Student entity) throws JSONException {
        String[] coordinates = findCoordinates(entity.getPostalCode());
        entity.setLatitude(coordinates[0]);
        entity.setLongitude(coordinates[1]);
        studentRepository.save(entity);
        return entity;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent())
            throw new Exception("The student was not found!");
        return student.get();
    }

    public void put(Student entity) throws JSONException {
        String[] coordinates = findCoordinates(entity.getPostalCode());
        entity.setLatitude(coordinates[0]);
        entity.setLongitude(coordinates[1]);
        studentRepository.save(entity);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    private String[] findCoordinates(String postalCode) throws JSONException {
        final String key = "AmTvUhwZUrIBrl1KxypQMFZDZYFuQmjrU_jiZCksNbjmRPhT_kqlHJoDnGKhaPBI";
        final String uri = String.format("http://dev.virtualearth.net/REST/v1/Locations?postalCode=%s&key=%s", postalCode, key);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri, String.class);

        JSONObject object = new JSONObject(response);

        String coordinates = object.getJSONArray("resourceSets")
                .getJSONObject(0)
                .getJSONArray("resources")
                .getJSONObject(0)
                .getJSONObject("point")
                .getString("coordinates");

        return coordinates.substring(1, coordinates.length() - 1).split(",");
    }

}
