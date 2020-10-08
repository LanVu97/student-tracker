/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.handler;

/**
 *
 * @author default
 */
public class Student {
    private String first_name;
    private String email;
    private  int id;

    public Student(String first_name, String email) {
        this.first_name = first_name;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String first_name, String email) {
        this.first_name = first_name;
        this.email = email;
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "first_name=" + first_name + ", email=" + email + ", id=" + id + '}';
    }

  
    
    
    
}
