package com.leeseungryeol.api.crs.web;

import com.leeseungryeol.api.crs.service.CourseService;
import com.leeseungryeol.api.crs.web.dto.CourseDto;
import com.leeseungryeol.api.crs.web.dto.CourseResponseDto;
import com.leeseungryeol.api.sec.CurrentUser;
import com.leeseungryeol.api.sec.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody CourseDto c){
        return ResponseEntity.ok(courseService.save(c));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseResponseDto>> list(@CurrentUser UserPrincipal userPrincipal){
        return ResponseEntity.ok(courseService.list(userPrincipal.getId()));
    }
}
