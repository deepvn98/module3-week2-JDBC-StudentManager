package service.student;

import model.Student;
import service.InterFaceService;

import java.util.List;

public interface StudentInterFace extends InterFaceService<Student> {
    void save(Student student,int[] courses);
    void update(int id, Student student, int [] courses);

}
