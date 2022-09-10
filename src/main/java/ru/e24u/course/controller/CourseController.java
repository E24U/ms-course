package ru.e24u.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.e24u.course.entity.Course;
import ru.e24u.course.service.CourseService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService service;

    @PostMapping("/course")
    public Course create(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/course/{id}")
    public void update(@PathVariable long id, @RequestBody Course course) {
        service.updateCourse(id, course);
    }

    @DeleteMapping("/course/{id}")
    public void delete(@PathVariable long id) {
        service.deleteCourse(id);
    }
}
