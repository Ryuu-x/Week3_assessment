
package com.springmvc.pmvc.controllers;

import java.util.*;
import org.springframework.ui.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import com.springmvc.pmvc.beans.*;
import com.springmvc.pmvc.dao.*;

@Controller
public class FacultyController {
    @Autowired
    FacultyDao facultyDao;

    @RequestMapping("/faculty-login")    
    public String showLoginForm(Model m) 
    {
        m.addAttribute("command", new Faculty());  
        return "faculty-login";
    }
    
    @RequestMapping(value="/validate-login", method = RequestMethod.POST)    
    public String validateLogin(@ModelAttribute("faculty") Faculty faculty, Model m) 
    {
        Faculty loggedInFaculty = facultyDao.validateLogin(faculty.getEmail(), faculty.getPass());
        if (loggedInFaculty != null) 
        {
            List<Course> courses = facultyDao.getAssignedCourses(loggedInFaculty.getId());
            m.addAttribute("list", courses);
            return "faculty-dashboard";
        }
        return "redirect:/faculty-login";
    }
}
