package student.maneger.student.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private StudentCourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/student")
	public List<Student> getStudentList() {
		return repository.searchAll();
	}

	@GetMapping("/studentsCourses")
	public List<StudentCourse> getStudentCourseList() {
		return courseRepository.getStudentCourseList();
	}

}


