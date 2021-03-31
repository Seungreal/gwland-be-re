package com.leeseungryeol.api.crs.domain;

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
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crs_num") private long crsNum;
    @Column(name="crs_name") private String crsName;

    @OneToMany(mappedBy = "course")
    private List<Recom> RecomList = new ArrayList<>();

    @Builder
    public Course(String crsName){
        this.crsName=crsName;
    }
}
