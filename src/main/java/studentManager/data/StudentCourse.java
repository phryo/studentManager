package studentManager.data;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {
    private String id;
    private String studentId;
    private String courseName;
    private Date startDate;
    private Date exceptedCompletionDate;
}
