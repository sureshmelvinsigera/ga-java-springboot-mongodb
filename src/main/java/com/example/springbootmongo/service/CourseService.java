package com.example.springbootmongo.service;

import com.example.springbootmongo.model.Course;

import java.util.List;


//implements the model
public interface CourseService {

    public Course addCourse(Course newCourse);

    public List<Course> listCourses();
}
