package sms.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sms.example.sms.entity.Student;
import sms.example.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementCrudAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementCrudAppApplication.class, args);
	}

	@Autowired
	private StudentRepository studentrepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
