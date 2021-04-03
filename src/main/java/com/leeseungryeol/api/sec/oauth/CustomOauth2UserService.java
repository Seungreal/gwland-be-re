package com.leeseungryeol.api.sec.oauth;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import com.leeseungryeol.api.usr.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.leeseungryeol.api.sec.UserPrincipal;
import com.leeseungryeol.api.sec.oauth.userInfo.KakaoUserInfo;
import com.leeseungryeol.api.sec.oauth.userInfo.GoogleUserInfo;
import com.leeseungryeol.api.sec.oauth.userInfo.NaverUserInfo;
import com.leeseungryeol.api.sec.oauth.userInfo.OAuth2UserInfo;
import com.leeseungryeol.api.usr.domain.User;
import com.leeseungryeol.api.usr.domain.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);

		try {
			return processOAuth2User(userRequest, oAuth2User);
		} catch (AuthenticationException ex) {
			throw ex;
		} catch (Exception ex) {
			// Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
			throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
		}
	}
	
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		OAuth2UserInfo oAuth2UserInfo = null;
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		switch(registrationId) {
			case "google": oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes()); break;
			case "kakao": oAuth2UserInfo = new KakaoUserInfo((Map)oAuth2User.getAttributes()); break;
			case "naver":oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response")); break;
			default: System.out.println("해당사항 없음");
		}
		
		Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
		
		User user;
		if (userOptional.isPresent()) {
			user = userOptional.get();

			user = updateExistingUser(user,oAuth2UserInfo);
		} else {
			// user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
			user = registerNewUser(oAuth2UserInfo);
		}

		return UserPrincipal.create(user, oAuth2User.getAttributes());
	}

	private User registerNewUser(OAuth2UserInfo oAuth2UserInfo){
		return userRepository.save(User.builder()
				.email(oAuth2UserInfo.getEmail())
				.age(oAuth2UserInfo.getAge())
				.username(oAuth2UserInfo.getUsername())
				.gender(oAuth2UserInfo.getGender())
				.provider(oAuth2UserInfo.getProvider())
				.providerId(oAuth2UserInfo.getProviderId())
				.roles(Arrays.asList(Role.USER))
				.build());
	}

	private User updateExistingUser(User user,OAuth2UserInfo oAuth2UserInfo){
		// user가 존재하면 update 해주기
		return userRepository.save(user);
	}
}