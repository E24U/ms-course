package ru.e24u.course.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.e24u.course.entity.Course;
import ru.e24u.course.repository.CourseRepo;

@Service
public record CourseServiceAPI(CourseRepo courseRepo) {

    private static final String URL_CATEGORY = "http://localhost:8081/api/v1/course/";

    private static RestTemplate restTemplate;

    public ResponseEntity<Course> createCourse(Course course) {
            return restTemplate.postForEntity(URL_CATEGORY, course, Course.class);
       }

    public Course findById(long id) {
                  return courseRepo.findById(id).orElse(null);
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
