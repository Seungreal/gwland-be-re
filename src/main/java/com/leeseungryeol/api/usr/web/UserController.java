package com.leeseungryeol.api.usr.web;

import com.leeseungryeol.api.sec.CurrentUser;
import com.leeseungryeol.api.sec.UserPrincipal;
import com.leeseungryeol.api.usr.domain.User;
import com.leeseungryeol.api.usr.domain.UserRepository;
import com.leeseungryeol.api.usr.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public User profile(@CurrentUser UserPrincipal userPrincipal){
        System.out.println("id:"+userPrincipal.getId());
        System.out.println("email:"+userPrincipal.getEmail());
        return userRepository.findById(userPrincipal.getId()).orElse(null);
    }
}
