package com.leeseungryeol.api.svy.web.dto;

import com.leeseungryeol.api.pce.domain.Place;
import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SurveyResponseDto {
    private PlaceDto place;
    private double score;

    @Builder
    public  SurveyResponseDto(Place place, double score){
        this.place = new PlaceDto(place);
        this.score = score;
    }
}
