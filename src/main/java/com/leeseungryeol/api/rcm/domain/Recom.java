package com.leeseungryeol.api.rcm.domain;

import com.leeseungryeol.api.crs.domain.Course;
import com.leeseungryeol.api.rev.domain.Review;
import com.leeseungryeol.api.svy.domain.Survey;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Recom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rcm_num") private long rcmNum;

    @ManyToOne
    @JoinColumn(name="crs_num")
    private Course course;
    @ManyToOne
    @JoinColumn(name="svy_num")
    private Survey survey;
    @ManyToOne
    @JoinColumn(name="rev_num")
    private Review review;
}
