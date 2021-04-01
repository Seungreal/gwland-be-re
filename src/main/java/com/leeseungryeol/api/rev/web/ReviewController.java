package com.leeseungryeol.api.rev.web;

import com.leeseungryeol.api.rev.service.ReviewService;
import com.leeseungryeol.api.rev.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(ReviewDto r){
        return ResponseEntity.ok(reviewService.save(r));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(ReviewDto r){
        return ResponseEntity.ok(reviewService.delete(r));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(reviewService.count());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ReviewDto>> findAll(){
        return ResponseEntity.ok((reviewService.findAll()));
    }
}
