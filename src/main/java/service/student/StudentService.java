package service.student;

import model.Country;
import model.Student;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentInterFace {
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Student> showAll() {
        List<Student> students = new ArrayList<>();
        String sql ="select s.name ,s.age, c.name from student s join country c on c.id = s.id_country";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("s.name");
                int age = resultSet.getInt("s.age");
                Student student = new Student(name,age);
                String name1 = resultSet.getString("c.name");
                Country country = new Country(name1);
                student.setCountry(country);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
    @Override
    public void createStudent(Student student) {
        String sql = "insert into student(name, age, id_country) value (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getCountry().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateStudent(int id, Student student) {
        String sql =
        PreparedStatement preparedStatement = connection.prepareStatement()

    }

    @Override
    public void removeStudent(int id) {

    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public Student findStudentByName(String name) {
        return null;
    }
}
