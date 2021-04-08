package com.leeseungryeol.api.svy.service;

import com.leeseungryeol.api.cmm.util.LocationDistance;
import com.leeseungryeol.api.pce.domain.Place;
import com.leeseungryeol.api.pce.domain.PlaceRepository;
import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import com.leeseungryeol.api.rev.domain.Review;
import com.leeseungryeol.api.svy.domain.SurveyRepository;
import com.leeseungryeol.api.svy.web.dto.SurveyDto;
import com.leeseungryeol.api.svy.web.dto.SurveyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final PlaceRepository placeRepository;

    public int save(SurveyDto s) {
        return surveyRepository.save(s.toEntity())!=null?1:0;
    }

    public List<List<SurveyResponseDto>> saveAndRecom(SurveyDto s){
        surveyRepository.save(s.toEntity());
        List<Place> places = placeRepository.findBySigungucode(s.getLocation());
        List<String> themes = themes(s);
        List<Double> scoresByTheme = scoresByTheme(places,themes);
        List<Double> scoresByStar = scoresByStar(places);

        List<List<SurveyResponseDto>> courses = basePlace(places,scoresByTheme,scoresByStar);
        for(List course:courses){
            switch (s.getDuration()){
                case "1":
                    nextPlace(course,places,scoresByTheme,scoresByStar,7);
                    nextPlace(course,places,scoresByTheme,scoresByStar,5);
                    break;
                case "2":
                    nextPlace(course,places,scoresByTheme,scoresByStar,8);
                    nextPlace(course,places,scoresByTheme,scoresByStar,6);
                    nextPlace(course,places,scoresByTheme,scoresByStar,4);
                    break;
                case "3":
                    nextPlace(course,places,scoresByTheme,scoresByStar,9);
                    nextPlace(course,places,scoresByTheme,scoresByStar,8);
                    nextPlace(course,places,scoresByTheme,scoresByStar,7);
                    nextPlace(course,places,scoresByTheme,scoresByStar,6);
                    nextPlace(course,places,scoresByTheme,scoresByStar,5);
            }
        }
        return courses;
    }

    public List<List<SurveyResponseDto>> basePlace(List<Place> places,List<Double> scoresByTheme,List<Double> scoresByStar){
        List<Double> scores = new ArrayList<>();
        for(int i=0;i<places.size();i++)
            scores.add(scoresByTheme.get(i)+scoresByStar.get(i));
        List<List<SurveyResponseDto>> courses = new ArrayList<>();
        for(int i=0;i<3;i++){
            int index = scores.indexOf(Collections.max(scores));
            List<SurveyResponseDto> course = new ArrayList<>();
            course.add(SurveyResponseDto.builder().place(places.get(index)).score(scores.get(index)).build());
            courses.add(course);
            scores.set(index,0.0);
        }
        return courses;
    }

    public void nextPlace(List<SurveyResponseDto> course,List<Place> places,List<Double> scoresByTheme,List<Double> scoresByStar,int ratio){
        List<Double> scores = new ArrayList<>();
        PlaceDto last = course.get(course.size()-1).getPlace();
        for(int i=0;i<places.size();i++){
            double temp;
            if(duplPlace(course,places.get(i))){
                temp = 0.0;
            }else {
                temp = (scoresByTheme.get(i) + scoresByStar.get(i) / ratio * 20)/ LocationDistance.distance(
                        Double.parseDouble(last.getMapy()),Double.parseDouble(places.get(i).getMapy()),Double.parseDouble(last.getMapx()),Double.parseDouble(places.get(i).getMapx()));
            }
            scores.add(temp);
        }
        double max = Collections.max(scores);
        int index = scores.indexOf(max);
        course.add(SurveyResponseDto.builder().place(places.get(index)).score(scores.get(index)).build());
    }

    public boolean duplPlace(List<SurveyResponseDto> course,Place p){
        for(SurveyResponseDto dto:course){
            if(dto.getPlace().getContentid()==p.getContentid())
                return true;
        }
        return false;
    }

    public List<String> themes(SurveyDto s){
        List<String> themes = new ArrayList<>();
        themes.add(s.getTheme1());
        if(s.getTheme2()!=null)
            themes.add(s.getTheme2());
        if(s.getTheme3()!=null)
            themes.add(s.getTheme3());
        return themes;
    }

    public List<Double> scoresByTheme(List<Place> p,List<String> s){
        List<Double> ls = new ArrayList<>();
        for(int i=0;i<p.size();i++){
            ls.add(0.0);
            for(int j=0;j<s.size();j++){
                switch (s.get(j)){
                    case "자연":
                        if(p.get(i).getCat1().equals("A01"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "맛집":
                        if(p.get(i).getCat1().equals("A05"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "역사":
                        if(p.get(i).getCat2().equals("A0201"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "휴양":
                        if(p.get(i).getCat2().equals("A0202"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "레포츠":
                        if(p.get(i).getCat1().equals("A03"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "축제":
                        if(p.get(i).getCat2().equals("A0207"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "체험":
                        if(p.get(i).getCat2().equals("A0203"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "쇼핑":
                        if(p.get(i).getCat2().equals("A04"))
                            ls.set(i,ls.get(i)+10);
                        break;
                    case "문화":
                        if(p.get(i).getCat2().equals("A0206"))
                            ls.set(i,ls.get(i)+10);
                        break;
                }
            }
        }
        return ls;
    }

    public List<Double> scoresByStar(List<Place> places){
        List<Double> ls = new ArrayList<>();
        for(Place p:places){
            double res = 3.0;
            for(Review r:p.getReviewList()){
                res+=Double.parseDouble(r.getRevStar());
            }
            res = res/(p.getReviewList().size()+1);
            ls.add(res);
        }
        return ls;
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
