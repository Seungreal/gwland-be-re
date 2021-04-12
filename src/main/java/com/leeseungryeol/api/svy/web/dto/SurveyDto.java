package com.leeseungryeol.api.svy.web.dto;

import com.leeseungryeol.api.svy.domain.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SurveyDto {
    private long svyNum;
    private String gender;
    private String age;
    private String season;
    private String partner;
    private String duration;
    private String location;
    private String theme1;
    private String theme2;
    private String theme3;

    public SurveyDto(Survey survey){
        this.svyNum = survey.getSvyNum();
        this.gender = survey.getGender();
        this.age = survey.getAge();
        this.season = survey.getSeason();
        this.partner = survey.getPartner();
        this.duration = survey.getDuration();
        this.location = survey.getLocation();
        this.theme1 = survey.getTheme1();
        this.theme2 = survey.getTheme2();
        this.theme3 = survey.getTheme3();
    }

    @Builder
    public SurveyDto(long svyNum,String gender, String age, String season, String partner, String duration, String location, String theme1, String theme2, String theme3) {
        this.svyNum = svyNum;
        this.gender = gender;
        this.age = age;
        this.season = season;
        this.partner = partner;
        this.duration = duration;
        this.location = location;
        this.theme1 = theme1;
        this.theme2 = theme2;
        this.theme3 = theme3;
    }

    public Survey toEntity(){
        return Survey.builder()
                .svyNum(this.svyNum)
                .gender(this.gender)
                .age(this.age)
                .season(this.season)
                .partner(this.partner)
                .duration(this.duration)
                .location(this.location)
                .theme1(this.theme1)
                .theme2(this.theme2)
                .theme3(this.theme3)
                .build();
    }
}
