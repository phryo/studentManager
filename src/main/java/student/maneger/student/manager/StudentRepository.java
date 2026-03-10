package student.maneger.student.manager;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students WHERE name=#{name}")
    List<Student> searchByName(String name);

    @Select("SELECT * FROM students")
    List<Student> searchAll();


}
