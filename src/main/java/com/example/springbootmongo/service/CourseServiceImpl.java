package com.example.springbootmongo.service;

import com.example.springbootmongo.model.Course;
import com.example.springbootmongo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//implementation
@Service
public class CourseServiceImpl implements CourseService {
    //bridges connection to courserepo for needed content/data
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course newCourse){
        return courseRepository.save(newCourse);
    }

    @Override
    public List<Course> listCourses(){
        return courseRepository.findAll();
    }


}
