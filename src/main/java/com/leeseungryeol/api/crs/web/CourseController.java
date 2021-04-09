package com.leeseungryeol.api.crs.web;

import com.leeseungryeol.api.crs.service.CourseService;
import com.leeseungryeol.api.crs.web.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody CourseDto c){
        return ResponseEntity.ok(courseService.save(c));
    }
}
