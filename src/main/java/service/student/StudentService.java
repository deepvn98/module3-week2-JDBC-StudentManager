package service.student;

import model.Country;
import model.Course;
import model.Student;
import service.connection.ConnectionJDBC;
import service.course.CourseInterface;
import service.course.CourseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentInterFace {
    Connection connection = ConnectionJDBC.getConnection();
    CourseInterface course = new CourseService();
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
                List<Course> courses = course.findListById(id);
                student.setCountry(country);
                student.setCourses(courses);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public void create(Student student) {

    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void save(Student student,int[] courses) {
        int id_student = 0;
        String sql = "insert into student(name, age, id_country) value (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getCountry().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                id_student = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql1 ="insert into class(id_student, id_course) value (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            for (int id:courses) {
                preparedStatement.setInt(2,id);
                preparedStatement.setInt(1,id_student);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(int id, Student student, int [] courses) {
        int id1 = 0;
        String sql ="update student set name = ?, age = ?,id_country = ? where id =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getCountry().getId());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                id1 = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql1 = "set id_course = ? where id_student = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            for (int i = 0; i < courses.length; i++){
                preparedStatement.setInt(1,courses[i]);
                preparedStatement.setInt(2,id1);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void remove(int id) {
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
    public Student findById(int id) {
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
    public List<Student> findListById(int id) {
        return null;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

}
