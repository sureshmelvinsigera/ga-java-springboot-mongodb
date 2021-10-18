package com.example.springbootmongo.controller;

import com.example.springbootmongo.model.Course;
import com.example.springbootmongo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//provides root to path url before entering endpoint nested inside class
//ex: domainName.com/root
@RequestMapping("/course")
public class CourseController {


    @Autowired
    CourseService courseService; //this is a bean, called once, never instantiated

    //now the url should be domainName.com/root/endpoint
    @GetMapping("/listCourses")
    public List<Course> listCourses(){
        return courseService.listCourses(); //comes from courseService implementation - inside courseService is linked with courseServiceImpl which inside courseServiceImpl is linked with courseRepository which inside is linked with mongodb Rest methods from its extension
    }

    //@PostMapping("/addCourse") - endpoint is domainName.com/course/addCourse
    @PostMapping //without different endpoint - to add course the path would be domainName.com/course
    //course model has 3 fields that is needed - so requestbody is needed to pass chunk of data
    public Course addCourse(@RequestBody Course newCourse){
        return courseService.addCourse(newCourse);
    }


}
