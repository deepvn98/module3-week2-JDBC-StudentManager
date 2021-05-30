package controller;

import model.Country;
import model.Course;
import model.Student;
import service.country.CountryInterFace;
import service.country.CountryService;
import service.course.CourseInterface;
import service.course.CourseService;
import service.student.StudentInterFace;
import service.student.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private StudentInterFace studentService = new StudentService();
    private CountryInterFace countryService = new CountryService();
    private CourseInterface courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "remove":
                removeForm(request, response);
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    private void removeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "student/remove.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        int id_country = student.getCountry().getId();
        Country country =countryService.findById(id_country);
        request.setAttribute("country",country);
        request.setAttribute("student",student);
        requestDispatcher.forward(request, response);
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "student/update.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        List<Country> countryList = countryService.showAll();
        List<Course> courses = courseService.showAll();
        request.setAttribute("courses", courses);
        request.setAttribute("countryList" ,countryList);
        request.setAttribute("student",student);
        requestDispatcher.forward(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "student/create.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        List<Country> countryList =countryService.showAll();
        List<Course> courses = courseService.showAll();
        request.setAttribute("countrylist",countryList);
        request.setAttribute("course",courses);
        requestDispatcher.forward(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "student/list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        List<Student> students = studentService.showAll();
        request.setAttribute("students",students);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.remove(id);
        response.sendRedirect("/StudentController");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int country = Integer.parseInt(request.getParameter("country"));
        Student student = new Student(name,age);
        Country country1 = countryService.findById(country);
        student.setCountry(country1);
        String[] course1 = request.getParameterValues("courses");
        int [] courses = new int[course1.length];
        for (int i = 0;i < courses.length;i++){
            courses[i] = Integer.parseInt(course1[i]);
        }
        studentService.update(id,student,courses);
        response.sendRedirect("/StudentController");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name,age);
        int country = Integer.parseInt(request.getParameter("country"));
        Country country2 = countryService.findById(country);
        student.setCountry(country2);
        String [] course1 = request.getParameterValues("course");
        int[] courses =new int[course1.length];
        for (int i = 0; i< courses.length; i++){
            courses[i] = Integer.parseInt(course1[i]);
        }
        studentService.save(student,courses);
        response.sendRedirect("/StudentController");
    }

}
