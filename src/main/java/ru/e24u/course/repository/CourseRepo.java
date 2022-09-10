package ru.e24u.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.e24u.course.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Course name(String name);
}
