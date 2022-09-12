package ru.e24u.course.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.e24u.course.dto.CategoryDto;

@RestController
@RequestMapping("/api/v2")
public class CourseControllerAPI {
    @Value("${category-url}")
    private String categoryUrl;

    private final RestTemplate restTemplate;

    public CourseControllerAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/course")
    public CategoryDto create(@RequestBody CategoryDto passport) {
        ResponseEntity<CategoryDto> response = restTemplate.postForEntity(categoryUrl + "/save", passport, CategoryDto.class);
        return response.getBody();
    }

    @GetMapping("/course/{id}")
    public CategoryDto findById(@PathVariable long id) {
        return restTemplate.getForObject(categoryUrl, CategoryDto.class, id);
    }

    @PutMapping("/course/{id}")
    public void update(@PathVariable long id, @RequestBody CategoryDto category) {
        restTemplate.put(categoryUrl + "/update/" + id, category, CategoryDto.class);
    }

    @DeleteMapping("/course/{id}")
    public void delete(@PathVariable long id) {
        restTemplate.delete(categoryUrl + "/delete/" + id);
    }
}
