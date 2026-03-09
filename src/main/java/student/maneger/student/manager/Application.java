package student.maneger.student.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo(@RequestParam String name) {
		Student student = repository.searchByName(name);
		if (student == null) {
			return name + " is not found";
		}
        return student.getName() + " " + student.getAge() + "歳";
	}

	@GetMapping("/studentList")
	public String getStudentList() {
		List<Student> studentList = repository.searchAll();
		StringBuilder studentListString = new StringBuilder();
		for (Student student : studentList) {
			studentListString
				.append(student.getName())
				.append(", ")
				.append(student.getAge())
				.append("\n");
		}
		return  studentListString.toString();
	}

	@PostMapping("/studentInfo")
	public void registerStudentInfo(String name, int age) {
		repository.registerStudent(name, age);
	}

	@PatchMapping("/studentInfo")
	public void updateStudentName(String name, int age) {
		repository.updateStudentAge(name, age);
	}

	@DeleteMapping("/studentInfo")
	public void deleteStudentInfo(@RequestParam String name) {
		repository.deleteStudent(name);
	}

}
