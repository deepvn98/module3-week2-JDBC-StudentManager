package service.student;

import model.Student;

import java.util.List;

public interface StudentInterFace {
    List<Student> showAll();

    void createStudent(Student student);

    void updateStudent(int id,Student student);

    void removeStudent(int id);

    Student findStudentById(int id);

    Student findStudentByName(String name);
}
