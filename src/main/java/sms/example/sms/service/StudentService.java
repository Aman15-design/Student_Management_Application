package sms.example.sms.service;
import java.util.*;

import sms.example.sms.entity.Student;
public interface StudentService {
List<Student> getAllStudents();

Student saveStudent(Student student);

Student getStudentById(Long id);
Student updateStudent(Student student);
void delStudent(Long id);
}
