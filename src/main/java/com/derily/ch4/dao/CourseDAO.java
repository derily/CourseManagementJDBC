package com.derily.ch4.dao;

import com.derily.ch4.bean.Course;
import com.derily.ch4.db.connection.DatabaseConnectionFactory;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {
    public void addCourse(Course course) throws SQLException{
        Connection con=DatabaseConnectionFactory.getConnectionFactory().getConnection();
        try{
            final String sql="insert into Course(name,credits) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            //set parameters
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredits());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                course.setId(rs.getInt(1));
            rs.close();
            stmt.close();
        }finally {
            con.close();
        }
    }
}
