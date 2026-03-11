package studentManager.service;

import java.util.List;
import java.util.stream.Collectors;
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
        List<Student> studentList;
        studentList = repository.searchAll().stream()
            .filter(student -> student.getAge() >= 30).collect(Collectors.toList());
        return studentList;
    }

    // 絞り込みをする。年齢が30代以上の人のみを抽出する
    // service内で完結する。
    // 抽出したリストをコントローラーに返す

    @GetMapping
    public List<StudentCourse> getStudentCourseList() {
        List<StudentCourse> studentCourseList;
        studentCourseList = repository.getStudentCourseList().stream()
            .filter(studentCourse -> studentCourse.getCourseName().equals("Java"))
            .collect(Collectors.toList());
        return studentCourseList;
    }

    // 絞り込み検索でJavaコースのみコース情報のみを抽出する
    // 抽出したリストをコントローラーに返す

}
