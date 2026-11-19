package com.mecerintered.coursemanager.service;

import com.mecerintered.coursemanager.entity.Course;
import com.mecerintered.coursemanager.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course changeCourseVenue(Long id, String newVenue) {

        Course course = courseRepository.findById(id).orElse(null);
        if(course == null){

            return null;
        }
        course.setCourseVenue(newVenue);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {

        courseRepository.deleteById(id);
    }
}
