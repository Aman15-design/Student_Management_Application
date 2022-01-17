package sms.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sms.example.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
