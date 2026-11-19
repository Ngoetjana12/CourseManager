package com.mecerintered.coursemanager.taskcontroller;

import com.mecerintered.coursemanager.entity.Course;
import com.mecerintered.coursemanager.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {

        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestParam String newVenue) {

        return courseService.changeCourseVenue(id, newVenue);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);
    }
}
