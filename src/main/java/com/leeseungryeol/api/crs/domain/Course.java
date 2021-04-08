package com.leeseungryeol.api.crs.domain;

import com.leeseungryeol.api.rcm.domain.Recom;
import com.leeseungryeol.api.usr.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crs_num") private long crsNum;
    @Column(name="crs_name") private String crsName;

    @ManyToOne
    @JoinColumn(name="usr_num")
    private User user;
    @ManyToOne
    @JoinColumn(name="rcm_num")
    private Recom recom;

    @Builder
    public Course(String crsName){
        this.crsName=crsName;
    }
}
