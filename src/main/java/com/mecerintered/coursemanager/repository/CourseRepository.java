package com.mecerintered.coursemanager.repository;

import com.mecerintered.coursemanager.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course getCourseById(Long id);
    Course changeVenue(Long id);
}
