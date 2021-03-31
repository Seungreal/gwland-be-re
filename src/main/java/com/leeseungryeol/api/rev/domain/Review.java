package com.leeseungryeol.api.rev.domain;

import com.leeseungryeol.api.pce.domain.Place;
import com.leeseungryeol.api.rcm.domain.Recom;
import com.leeseungryeol.api.usr.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rev_num")private long revNum;
    @Column(name="rev_name")private String revName;
    @Column(name="rev_star")private String revStar;
    @Column(name="rev_content")private String revContent;
    @Column(name="rev_date")private String revDate;

    @OneToMany(mappedBy= "review")
    private List<Recom> recom = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="usr_num")
    private User user;

    @ManyToOne
    @JoinColumn(name="pce_num")
    private Place place;

    @Builder
    public Review(String revName, String revStar, String revContent, String revDate, User user, Place place) {
        this.revName = revName;
        this.revStar = revStar;
        this.revContent = revContent;
        this.revDate = revDate;
        this.user = user;
        this.place = place;
    }
}
