package com.leeseungryeol.api.svy.web;

import com.leeseungryeol.api.svy.service.SurveyService;
import com.leeseungryeol.api.svy.web.dto.SurveyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/survey")
public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody SurveyDto s){
        return ResponseEntity.ok(surveyService.save(s));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(surveyService.count());
    }
    @GetMapping("/list")
    public ResponseEntity<Page<SurveyDto>> list(Pageable pageable){
        return ResponseEntity.ok(surveyService.list(pageable));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestBody SurveyDto s){
        return ResponseEntity.ok(surveyService.delete(s));
    }
}
