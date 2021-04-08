package com.leeseungryeol.api.pce.service;

import com.leeseungryeol.api.pce.domain.PlaceRepository;
import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public int save(PlaceDto p){
        return placeRepository.save(p.toEntity())!=null?1:0;
    }

    public int saveAll(List<PlaceDto> ls) {
        Stream<PlaceDto> stream = ls.stream();
        stream.forEach(placeDto -> {
            switch (placeDto.getSigungucode()){
                case "5":
                    placeDto.setSigungucode("속초");
                    break;
                default:
                    placeDto.setSigungucode("강원도");
            }
        });
        return placeRepository.saveAll(stream
                .map(p->p.toEntity())
                .collect(Collectors.toList()))!=null?1:0;
    }

    @Transactional
    public void updateOverview(PlaceDto p){
            placeRepository.findById(p.getContentid()).get().updateDetail(p.getOverview());
    }

    public List<PlaceDto> list() {
        return placeRepository.findAll().stream().map(p->new PlaceDto(p)).collect(Collectors.toList());
    }

    public PlaceDto getOne(long contentid){
        return new PlaceDto(placeRepository.getOne(contentid));
    }
}
