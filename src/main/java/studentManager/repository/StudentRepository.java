package studentManager.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import studentManager.data.Student;
import studentManager.data.StudentCourse;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students")
    List<Student> searchAll();

    @Select("SELECT * FROM students_courses")
    List<StudentCourse> getStudentCourseList();
}
