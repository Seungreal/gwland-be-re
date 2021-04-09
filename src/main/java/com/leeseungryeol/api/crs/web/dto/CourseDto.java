package com.leeseungryeol.api.crs.web.dto;

import com.leeseungryeol.api.crs.domain.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CourseDto {
    private long crsNum;
    private String crsName;
    private List<Long> places;
    private long usrNum;
}
