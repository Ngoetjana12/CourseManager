package com.mecerintered.coursemanager.service;

import com.mecerintered.coursemanager.entity.Course;
import com.mecerintered.coursemanager.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
