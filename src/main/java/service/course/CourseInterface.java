package service.course;

import model.Country;
import model.Course;
import model.Student;
import service.InterFaceService;

import java.util.List;

public interface CourseInterface extends InterFaceService<Course> {
    List<Course> findListById(int id_student);
}
