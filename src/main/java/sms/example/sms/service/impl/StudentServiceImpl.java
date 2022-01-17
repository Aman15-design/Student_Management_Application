package sms.example.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import sms.example.sms.entity.Student;
import sms.example.sms.repository.StudentRepository;
import sms.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	private StudentRepository StudentRepo;
	
	//When spring bean has one constructor than we can avoid using @Autowired Annotation
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		StudentRepo = studentRepo;
	}
	@Override
	public List<Student> getAllStudents() {
		
		return StudentRepo.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return StudentRepo.save(student);
	}
	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return StudentRepo.findById(id).get();
	}
	
	@Override
	public Student updateStudent(Student student) {
		return StudentRepo.save(student);
	}
	@Override
	public void delStudent(Long id) {
		// TODO Auto-generated method stub
		StudentRepo.deleteById(id);
		
	}

}
