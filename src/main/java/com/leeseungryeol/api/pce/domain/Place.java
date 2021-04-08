package com.leeseungryeol.api.pce.domain;

import com.leeseungryeol.api.rcm.domain.Recom;
import com.leeseungryeol.api.rev.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Place {
    @Id
    @Column(name="contentid") private long contentid;
    @Column(name="addr1") private String addr1;
    @Column(name="addr2") private String addr2;
    @Column(name="areacode") private String areacode;
    @Column(name="cat1") private String cat1;
    @Column(name="cat2") private String cat2;
    @Column(name="cat3") private String cat3;
    @Column(name="contenttypeid") private String contenttypeid;
    @Column(name="createdtime") private String createdtime;
    @Column(name="firstimage") private String firstimage;
    @Column(name="firstimage2") private String firstimage2;
    @Column(name="mapx") private String mapx;
    @Column(name="mapy") private String mapy;
    @Column(name="mlevel") private String mlevel;
    @Column(name="modifiedtime") private String modifiedtime;
    @Column(name="readcount") private String readcount;
    @Column(name="sigungucode") private String sigungucode;
    @Column(name="tel") private String tel;
    @Column(name="title") private String title;
    @Column(name="zipcode") private String zipcode;
    @Column(name="overview", columnDefinition="text") private String overview;

    @OneToMany(mappedBy = "place")
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "place")
    private List<Recom> recomList = new ArrayList<>();

    @Builder
    public Place(long contentid, String addr1, String addr2, String areacode, String cat1, String cat2, String cat3, String contenttypeid, String createdtime, String firstimage, String firstimage2, String mapx, String mapy, String mlevel, String modifiedtime, String readcount, String sigungucode, String tel, String title, String zipcode, String overview) {
        this.contentid = contentid;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areacode = areacode;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.contenttypeid = contenttypeid;
        this.createdtime = createdtime;
        this.firstimage = firstimage;
        this.firstimage2 = firstimage2;
        this.mapx = mapx;
        this.mapy = mapy;
        this.mlevel = mlevel;
        this.modifiedtime = modifiedtime;
        this.readcount = readcount;
        this.sigungucode = sigungucode;
        this.tel = tel;
        this.title = title;
        this.zipcode = zipcode;
        this.overview = overview;
    }

    public void updateDetail(String overview){
        this.overview = overview;
    }
}
