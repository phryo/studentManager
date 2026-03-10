package studentManager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import studentManager.data.Student;
import studentManager.data.StudentCourse;
import studentManager.repository.StudentRepository;

@Service
public class StudentService {

    private  StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getStudentList() {
        return repository.searchAll();
    }

    @GetMapping
    public List<StudentCourse> getStudentCourseList() {
        return repository.getStudentCourseList();
    }

}
