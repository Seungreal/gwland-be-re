package com.leeseungryeol.api.usr.web.dto;

import com.leeseungryeol.api.usr.domain.Role;
import com.leeseungryeol.api.usr.domain.User;
import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
public class UserDto {
    private long usrNum;
    private String provider;
    private String providerId;
    private String username;
    private String email;
    private String age;
    private String gender;
    private List<Role> roles;

    public UserDto(User user){
        this.usrNum = user.getUsrNum();
        this.provider = user.getProviderId();
        this.providerId = user.getProviderId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.roles = user.getRoles();
    }
}
