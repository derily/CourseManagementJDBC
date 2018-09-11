package com.derily.ch4.bean;

import com.derily.ch4.dao.CourseDAO;

import java.sql.SQLException;

public class Course {
    private int id;
    private String name;
    private int credits;

    private CourseDAO courseDAO=new CourseDAO();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public boolean isValidCourse(){
        return name!=null && credits!=0;
    }

    public void addCourse() throws SQLException{
        courseDAO.addCourse(this);
    }


}
