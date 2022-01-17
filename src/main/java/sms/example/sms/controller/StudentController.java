package sms.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sms.example.sms.entity.Student;
import sms.example.sms.service.StudentService;

@Controller //We need to make this class as MVC class
public class StudentController {
private StudentService studentservice;

public StudentController(StudentService studentservice) {
	super();
	this.studentservice = studentservice;
}
//Handler Method
@GetMapping("/students")
public String listStudent(Model model) {
	model.addAttribute("students",studentservice.getAllStudents());
	System.out.println("HERE:-------------------------------- "+model);
	return "students";
}
@GetMapping("/students/new")
public String createStudentForm(Model model)
{
	Student student=new Student();
	model.addAttribute("student",student);
	return "create_student";
}

@PostMapping("/students")
public String saveStudent(@ModelAttribute("student") Student students) {
	studentservice.saveStudent(students);
	return "redirect:/students";
}


@GetMapping("/students/edit/{id}")
public String editStudentForm(@PathVariable Long id, Model model)
{
	model.addAttribute("student",studentservice.getStudentById(id));
	return "update_student";
}


@PostMapping("/students/{id}")
public String updateStudent(@PathVariable Long id,
		@ModelAttribute("student") Student student,
		Model model) {
	
	// get student from database by id
	Student existingStudent = studentservice.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	existingStudent.setAddress(student.getAddress());
	
	// save updated student object
	studentservice.updateStudent(existingStudent);
	return "redirect:/students";		
}
//Handler method to handle delete button
@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable Long id) {
	studentservice.delStudent(id);
	return "redirect:/students";
	
}

}
