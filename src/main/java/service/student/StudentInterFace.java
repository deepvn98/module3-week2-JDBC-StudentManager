package service.student;

import model.Student;
import service.InterFaceService;

import java.util.List;

public interface StudentInterFace extends InterFaceService<Student> {
void saver (Student student,int[]course);
List<Student> showStudentAndCourse();

//    List<Student> showAll();
//
//    void createStudent(Student student);
//
//    void updateStudent(int id,Student student);
//
//    void removeStudent(int id);
//
//    Student findStudentById(int id);
//
//    Student findStudentByName(String name);
}
