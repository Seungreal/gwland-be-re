package com.leeseungryeol.api.usr.domain;

import com.leeseungryeol.api.crs.domain.Course;
import com.leeseungryeol.api.rev.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usrNum;
    private String provider;
    private String providerId;
    private String username;
    private String email;
    private String age;
    private String gender;
    @ElementCollection
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Course> courseList = new ArrayList<>();

    @Builder
    public User(String provider, String providerId, String username, String email, String age, String gender, List<Role> roles) {
        this.provider = provider;
        this.providerId = providerId;
        this.username = username;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.roles = roles;
    }
}
