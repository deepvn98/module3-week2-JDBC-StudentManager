package service.course;

import model.Course;
import service.InterFaceService;

import java.util.List;

public interface CourseInterface extends InterFaceService<Course> {
    List<Course> findListById(int id_student);
}
