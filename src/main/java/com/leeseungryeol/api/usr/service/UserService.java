package com.leeseungryeol.api.usr.service;

import com.leeseungryeol.api.usr.domain.UserRepository;
import com.leeseungryeol.api.usr.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto getOne(long id){
        return new UserDto(userRepository.getOne(id));
    }
    public long count(){
        return userRepository.count();
    }
    public Page<UserDto> list(Pageable pageable){
        return userRepository.findAll(pageable).map(user -> new UserDto(user));
    }
}
