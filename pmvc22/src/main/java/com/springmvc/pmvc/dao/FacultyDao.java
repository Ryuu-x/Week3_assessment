package com.springmvc.pmvc.dao;

import java.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import com.springmvc.pmvc.beans.*;

public class FacultyDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Faculty validateLogin(String email, String pass) 
    {
        String query = "SELECT * FROM faculty WHERE email = ? AND pass = ?";
        List<Faculty> faculties = jdbcTemplate.query(query, new Object[]{email, pass}, (rs, rowNum) ->
            new Faculty(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pass"), rs.getString("mob"))
        );
        return faculties.isEmpty() ? null : faculties.get(0);
    }

    
    public List<Course> getAssignedCourses(int facultyId) 
    {
        return jdbcTemplate.query("SELECT c.* FROM course c INNER JOIN faculty_course fc ON c.id = fc.course_id WHERE fc.faculty_id = ?", 
            new Object[]{facultyId}, (rs, rowNum) -> 
                new Course(rs.getInt("id"), rs.getString("name"), rs.getString("duration"))
        );
    }
}
