package ru.e24u.course.service;

import org.springframework.stereotype.Service;
import ru.e24u.course.entity.Course;
import ru.e24u.course.repository.CourseRepo;

@Service
public record CourseService(CourseRepo courseRepo) {

    public Course createCourse(Course course) {
        if (courseRepo.name(course.getName()) != null) {
            throw new IllegalArgumentException("Статья с таким именем уже существует");
        }
        try {
            return courseRepo.save(course);
        } catch (Exception e) {
            throw new IllegalArgumentException("Проверьте правильность заполнения статьи");
        }
    }

    public Course findById(long id) {
        try {
            return courseRepo.findById(id).orElse(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Статья не найдена");
        }
    }

    public void updateCourse(long id, Course course) {
        try {
            Course rsl = courseRepo.findById(id).get();
            rsl.setName(course.getName());
            rsl.setDescription(course.getDescription());
            courseRepo.save(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteCourse(long id) {
        try {
            Course rsl = new Course();
            rsl.setId(id);
            courseRepo.delete(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
