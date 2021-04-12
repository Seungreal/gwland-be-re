package com.leeseungryeol.api.crs.web.dto;

import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CourseResponseDto {
    private long crsNum;
    private String crsName;
    private List<PlaceDto> places;
    private List<Double> distances;

    @Builder
    public CourseResponseDto(long crsNum,String crsName,List<PlaceDto> places,List<Double> distances){
        this.crsNum = crsNum;
        this.crsName = crsName;
        this.places = places;
        this.distances = distances;
    }
}
