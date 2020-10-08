/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.handler;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author default
 */
public class StudentControllerServlet extends HttpServlet {
    
    private static final Logger _Logger = Logger.getLogger(StudentControllerServlet.class);
    
    StudentDB listStudentDB = new StudentDB();
    ArrayList<Student> list_Students = null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get command parameter
        String command = req.getParameter("command");
        
        if (command == null) {
            command = "list";
        }
        try {
            switch (command) {
                case "list":
                    getStudent(req, resp);
                    break;
                case "add":
                    addStudent(req, resp);
                    break;
                case "load":
                    loadStudent(req, resp);
                    break;
                
                case "update":
                    updateStudent(req, resp);
                    break;
                
                default:
                    getStudent(req, resp);
            }
            
        } catch (Exception e) {
            _Logger.error(e.getMessage(), e);
        }

        //To change body of generated methods, choose Tools | Templates.
    }
    
    protected void getStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            list_Students = listStudentDB.getListStudent();
            req.setAttribute("list_Student", list_Students);
            
            RequestDispatcher dis = getServletContext().getRequestDispatcher("/example.jsp");
            System.out.println(dis);
            dis.forward(req, resp);
            
        } catch (IOException | ServletException e) {
            _Logger.error(e.getMessage(), e);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String first_name = req.getParameter("first_name");
            String email = req.getParameter("email");
            
            listStudentDB.addStudent(first_name, email);
            getStudent(req, resp);
        } catch (Exception e) {
            _Logger.error(e.getMessage(), e);
        }
    }
    
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String StudentID = req.getParameter("studentID");
            int id = Integer.parseInt(StudentID);
            String first_name = req.getParameter("first_name");
            String email = req.getParameter("email");
            
            listStudentDB.updateStudent(id, first_name, email);
            getStudent(req, resp);
        } catch (Exception e) {
            _Logger.error(e.getMessage(), e);      
        }
    }
    
    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // lay id
            String studentID = req.getParameter("studentID");
            //   System.out.println(StudentID);
            int id = Integer.parseInt(studentID);
            System.out.println(id);
            // lay data

            Student theStudent = listStudentDB.loadStudent(id);

            // tao student
            req.setAttribute("The_student", theStudent);
            // gui cho jsp
            RequestDispatcher dispatcher = req.getRequestDispatcher("/update-student-form.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            _Logger.error(e.getMessage(), e);
        }
        
    }
    
}
