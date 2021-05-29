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
        String sql ="select s.id, s.name ,s.age, c.name from student s join country c on c.id = s.id_country";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("s.id");
                String name = resultSet.getString("s.name");
                int age = resultSet.getInt("s.age");
                Student student = new Student(id,name,age);
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
        String sql ="update student set name = ?, age = ?,id_country = ? where id =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getCountry().getId());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeStudent(int id) {
        String sql = "delete from student where id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {

        }
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        String sql ="select * from student where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                int id1 = set.getInt("id");
                String name = set.getString("name");
                int age = set.getInt("age");
                student = new Student(id1,name,age);
                int country = set.getInt("id_country");
                Country country1 = new Country(country);
                student.setCountry(country1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {

        }
        return student;
    }

    @Override
    public Student findStudentByName(String name) {
        return null;
    }
}
