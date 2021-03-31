package com.leeseungryeol.api.pce.web;

import com.leeseungryeol.api.pce.service.PlaceService;
import com.leeseungryeol.api.pce.web.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody PlaceDto p){
        return ResponseEntity.ok(placeService.save(p));
    }
    @PostMapping("/saveAll")
    public ResponseEntity<Integer> saveAll(@RequestBody List<PlaceDto> ls){
        return ResponseEntity.ok(placeService.saveAll(ls));
    }
    @PutMapping("/updateOverview")
    public ResponseEntity<Integer> updateOverview(@RequestBody PlaceDto p){
        placeService.updateOverview(p);
        return ResponseEntity.ok(1);
    }
    @GetMapping("/list")
    public ResponseEntity<List<PlaceDto>> list(){
        return ResponseEntity.ok(placeService.list());
    }
    @GetMapping("/one/{contentid}")
    public ResponseEntity<PlaceDto> getOne(@PathVariable long contentid){
        return ResponseEntity.ok(placeService.getOne(contentid));
    }
}
