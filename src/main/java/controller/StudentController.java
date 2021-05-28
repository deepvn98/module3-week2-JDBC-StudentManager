package controller;

import model.Student;
import service.country.CountryInterFace;
import service.country.CountryService;
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
                break;
            case "remove":
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "student/create.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
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

                break;
            case "update":
                break;
            case "remove":
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }

}
