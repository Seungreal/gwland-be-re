package com.leeseungryeol.api.pce.web.dto;

import com.leeseungryeol.api.pce.domain.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaceDto {
    private long contentid;
    private String addr1;
    private String addr2;
    private String areacode;
    private String cat1;
    private String cat2;
    private String cat3;
    private String contenttypeid;
    private String createdtime;
    private String firstimage;
    private String firstimage2;
    private String mapx;
    private String mapy;
    private String mlevel;
    private String modifiedtime;
    private String readcount;
    private String sigungucode;
    private String tel;
    private String title;
    private String zipcode;
    private String overview;

    public PlaceDto(Place p){
        this.contentid = p.getContentid();
        this.addr1 = p.getAddr1();
        this.addr2 = p.getAddr2();
        this.areacode = p.getAreacode();
        this.cat1 = p.getCat1();
        this.cat2 = p.getCat2();
        this.cat3 = p.getCat3();
        this.contenttypeid = p.getContenttypeid();
        this.createdtime = p.getCreatedtime();
        this.firstimage = p.getFirstimage();
        this.firstimage2 = p.getFirstimage2();
        this.mapx = p.getMapx();
        this.mapy = p.getMapy();
        this.mlevel = p.getMlevel();
        this.modifiedtime = p.getModifiedtime();
        this.readcount = p.getReadcount();
        this.sigungucode = p.getSigungucode();
        this.tel = p.getTel();
        this.title = p.getTitle();
        this.zipcode = p.getZipcode();
        this.overview = p.getOverview();
    }

    @Builder
    public PlaceDto(long contentid, String addr1, String addr2, String areacode, String cat1, String cat2, String cat3, String contenttypeid, String createdtime, String firstimage, String firstimage2, String mapx, String mapy, String mlevel, String modifiedtime, String readcount, String sigungucode, String tel, String title, String zipcode, String overview) {
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
    @Builder
    public PlaceDto(String overview){
        this.overview = overview;
    }

    public Place toEntity(){
        return Place.builder()
                .contentid(this.contentid)
                .addr1(this.addr1)
                .addr2(this.addr2)
                .areacode(this.areacode)
                .cat1(this.cat1)
                .cat2(this.cat2)
                .cat3(this.cat3)
                .contenttypeid(this.contenttypeid)
                .createdtime(this.createdtime)
                .firstimage(this.firstimage)
                .firstimage2(this.firstimage2)
                .mapx(this.mapx)
                .mapy(this.mapy)
                .mlevel(this.mlevel)
                .modifiedtime(this.modifiedtime)
                .readcount(this.readcount)
                .sigungucode(this.sigungucode)
                .tel(this.tel)
                .title(this.title)
                .zipcode(this.zipcode)
                .overview(this.overview)
                .build();
    }
}
