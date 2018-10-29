package br.com.fatesg.goschoolrest.repositories;

import br.com.fatesg.goschoolrest.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
