package com.leeseungryeol.api.rev.web.dto;

import com.leeseungryeol.api.rev.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewDto {
    private long revNum;
    private String revName;
    private String revStar;
    private String revContent;
    private String revDate;

    public ReviewDto(Review r){
        this.revNum=r.getRevNum();
        this.revName=r.getRevName();
        this.revStar=r.getRevStar();
        this.revContent=r.getRevContent();
        this.revDate=r.getRevDate();
    }

    public Review toEntity(){
        return Review.builder()
                .revNum(this.revNum)
                .revName(this.revName)
                .revStar(this.revStar)
                .revContent(this.revContent)
                .revDate(this.revDate)
                .build();
    }
}
