package studentManager;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentCourseRepository {

    @Select("SELECT * FROM students_courses WHERE course_Name=#{courseName}")
    List<StudentCourse> searchByCourseName(String courseName);

    @Select("SELECT * FROM students_courses")
    List<StudentCourse> getStudentCourseList();
}
