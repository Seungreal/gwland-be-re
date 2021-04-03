package com.leeseungryeol.api.sec;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leeseungryeol.api.usr.domain.User;
import com.leeseungryeol.api.usr.domain.UserRepository;

@RequiredArgsConstructor
@Service 
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(() ->
				new UsernameNotFoundException("User not found with email : " + email));
			return UserPrincipal.create(user);
	}

	public UserDetails loadUserById(Long id){
		User user = userRepository.findById(id).orElseThrow();
			return UserPrincipal.create(user);
	}
}
