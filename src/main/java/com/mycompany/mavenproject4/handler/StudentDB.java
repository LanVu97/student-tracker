/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.handler;

import com.mycompany.mavenproject4.mysql.MySqlClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author default
 */
public class StudentDB {

    private static final Logger _Logger = Logger.getLogger(StudentDB.class);

    public ArrayList<Student> getListStudent() {
        // PrintWriter writer = response.getWriter();
        ArrayList<Student> listStudent = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySqlClient.Instance.getConnection();

            Statement statement = conn.createStatement();
            String sql = "select * from student";
            ResultSet rs = statement.executeQuery(sql);

            int count = 1;

            while (rs.next()) {
//                writer.println(String.format("User #%d: %-15s %s", count++,
//                        rs.getString("first_name"), rs.getString("email")));

                Student user = new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("email"));
                listStudent.add(user);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            _Logger.error(ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }

            }
        }
        return listStudent;

    }

    void addStudent(String first_name, String email) {

        Connection conn = null;
        try {
            conn = MySqlClient.Instance.getConnection();

            String sql = "insert into student (first_name, email)" + "values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, first_name);
            statement.setString(2, email);
            statement.execute();

//            int count = 1;
//                writer.println(String.format("User #%d: %-15s %s", count++,
//                        rs.getString("first_name"), rs.getString("email")));
            //  Student user = new Student(first_name, email);
            //   listStudent.add(user);
            // rs.close();
            statement.close();
        } catch (SQLException ex) {
            _Logger.error(ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    _Logger.error(ex.getMessage(), ex);
                }

            }
        }
    }

    void updateStudent(int id, String first_name, String email) {
        Connection conn = null;
        try {
            conn = MySqlClient.Instance.getConnection();

            String sql = "update student set "
                    + "first_name = ? ,"
                    + "email = ?"
                    + "where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, first_name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.execute();

            statement.close();
        } catch (SQLException ex) {
            _Logger.error(ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    _Logger.error(ex.getMessage(), ex);
                }

            }
        }
    }

    Student loadStudent(int id) throws Exception {

        Connection conn = null;
        Student user = null;
        try {

            conn = MySqlClient.Instance.getConnection();

            String sql = "select * from student where id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                user = new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("email"));

            } else {
                throw new Exception("could find student id:" + id);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            _Logger.error(ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    _Logger.error(ex.getMessage(), ex);
                }

            }
        }
        return user;
    }

    public static void main(String[] args) throws Exception {
        StudentDB db = new StudentDB();
//        db.updateStudent(1, "lan2", "lanvu@gmail.com");
        Student loadStudent = db.loadStudent(1);
        System.out.println("db: " + loadStudent);
    }
}
