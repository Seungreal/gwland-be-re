package com.leeseungryeol.api.svy.service;

import com.leeseungryeol.api.svy.domain.SurveyRepository;
import com.leeseungryeol.api.svy.web.dto.SurveyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public int save(SurveyDto s) {
        return surveyRepository.save(s.toEntity())!=null?1:0;
    }

    public Page<SurveyDto> list(Pageable pageable) {
        return surveyRepository.findAll(pageable).map(s->SurveyDto.builder()
                .svyNum(s.getSvyNum()).age(s.getAge()).gender(s.getGender()).duration(s.getDuration()).location(s.getLocation())
                .season(s.getSeason()).partner(s.getPartner()).theme1(s.getTheme1()).theme2(s.getTheme2()).theme3(s.getTheme3()).build());
    }

    public long count() {
        return surveyRepository.count();
    }

    public int delete(SurveyDto s){
        surveyRepository.delete(s.toEntity());
        return surveyRepository.existsById(s.getSvyNum())?0:1;
    }
}
