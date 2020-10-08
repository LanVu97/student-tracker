/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.handler;

import com.mycompany.mavenproject4.mysql.MySqlClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author default
 */
public class TestStudent extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        ArrayList<Student> listStudent = new ArrayList<>();
         PrintWriter writer = resp.getWriter();
        Connection conn = null;
        try {
            conn = MySqlClient.Instance.getConnection();

            Statement statement = conn.createStatement();
            String sql = "select first_name, email from student";
            ResultSet rs = statement.executeQuery(sql);

            int count = 1;

            while (rs.next()) {
//                writer.println(String.format("User #%d: %-15s %s", count++,
//                        rs.getString("first_name"), rs.getString("email")));
                writer.println(rs.getString("first_name"));
                Student user = new Student(rs.getString("first_name"), rs.getString("email"));
                listStudent.add(user);
                writer.println(listStudent.get(0).getEmail());
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
