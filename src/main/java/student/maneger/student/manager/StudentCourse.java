package student.maneger.student.manager;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {
    private String ID;
    private String studentID;
    private String courseName;
    private Date startDate;
    private Date exceptedCompletionDate;
}
