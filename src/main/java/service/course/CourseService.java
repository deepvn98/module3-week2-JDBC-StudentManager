package service.course;

import model.Course;
import model.Student;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseInterface{
    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Course> showAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "select * from course";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Course course = new Course(id,name);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courses;
    }

    @Override
    public void create(Course course) {

    }

    @Override
    public void update(int id, Course course) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course findByName(String name) {
        return null;
    }

    @Override
    public List<Course> findListById(int id_student) {
        List<Course> courses = new ArrayList<>();
        String sql = "select name from course join class c on course.id = c.id_course where c.id_student = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_student);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                Course course = new Course(name);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return courses;
    }
}
