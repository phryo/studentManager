package studentManager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studentManager.data.Student;
import studentManager.data.StudentCourse;
import studentManager.service.StudentService;

@RestController
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public List<Student> seachStudentList() {
        return service.getStudentList();
    }

    @GetMapping("/studentsCourses")
    public List<StudentCourse> searchStudentCourseList() {
        return service.getStudentCourseList();
    }

}
