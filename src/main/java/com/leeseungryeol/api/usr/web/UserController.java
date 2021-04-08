package com.leeseungryeol.api.usr.web;

import com.leeseungryeol.api.sec.CurrentUser;
import com.leeseungryeol.api.sec.UserPrincipal;
import com.leeseungryeol.api.usr.service.UserService;
import com.leeseungryeol.api.usr.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> profile(@CurrentUser UserPrincipal userPrincipal){
        return ResponseEntity.ok(userService.getOne(userPrincipal.getId()));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(userService.count());
    }

    @GetMapping("/list")
    public ResponseEntity<Page<UserDto>> list(Pageable pageable){
        return ResponseEntity.ok(userService.list(pageable));
    }
}
