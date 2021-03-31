package com.leeseungryeol.api.svy.domain;

import com.leeseungryeol.api.pce.domain.Place;
import com.leeseungryeol.api.rcm.domain.Recom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="svy_num") private long svyNum;
    private String gender;
    private String age;
    private String season;
    private String partner;
    private String duration;
    private String location;
    private String theme1;
    private String theme2;
    private String theme3;

    @ManyToOne
    @JoinColumn(name="contentid")
    private Place place;

    @OneToMany(mappedBy = "survey",fetch = FetchType.EAGER)
    private List<Recom> RecomList = new ArrayList<>();

    @Builder
    public Survey(long svyNum, String gender, String age, String season, String partner, String duration, String location, String theme1, String theme2, String theme3, Place place) {
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
        this.place = place;
    }
}
