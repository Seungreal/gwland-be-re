package com.leeseungryeol.api.crs.web.dto;

import com.leeseungryeol.api.crs.domain.Course;
import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import lombok.Builder;
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

    @Builder
    public CourseDto(String crsName, List<Long> places, long usrNum) {
        this.crsName = crsName;
        this.places = places;
        this.usrNum = usrNum;
    }
}
