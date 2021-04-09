package com.leeseungryeol.api.crs.service;

import com.leeseungryeol.api.crs.domain.Course;
import com.leeseungryeol.api.crs.domain.CourseRepository;
import com.leeseungryeol.api.crs.web.dto.CourseDto;
import com.leeseungryeol.api.usr.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public int save(CourseDto c){
        return courseRepository.save(toEntity(c))!=null?1:0;
    }

    public Course toEntity(CourseDto c){
        return Course.builder()
                .crsName(c.getCrsName())
                .places(c.getPlaces())
                .user(userRepository.findById(c.getUsrNum()).orElse(null)).build();
    }
}
