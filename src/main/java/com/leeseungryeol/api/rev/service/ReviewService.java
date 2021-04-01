package com.leeseungryeol.api.rev.service;

import com.leeseungryeol.api.rev.domain.ReviewRepository;
import com.leeseungryeol.api.rev.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public int save(ReviewDto r){
        return reviewRepository.save(r.toEntity())!=null?1:0;
    }

    public int delete(ReviewDto r){
        reviewRepository.delete(r.toEntity());
        return reviewRepository.existsById(r.getRevNum())?0:1;
    }

    public long count(){
        return reviewRepository.count();
    }

    public List<ReviewDto> findAll(){
        return reviewRepository.findAll().stream().map(r->new ReviewDto(r)).collect(Collectors.toList());
    }
}
