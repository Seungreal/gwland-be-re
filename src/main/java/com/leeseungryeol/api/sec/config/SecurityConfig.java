package com.leeseungryeol.api.sec.config;

import com.leeseungryeol.api.sec.TokenAuthenticationFilter;
import com.leeseungryeol.api.sec.oauth.HttpCookieOAuth2AuthorizationRequestRepository;
import com.leeseungryeol.api.sec.oauth.OAuth2AuthenticationFailureHandler;
import com.leeseungryeol.api.sec.oauth.OAuth2AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.leeseungryeol.api.sec.oauth.CustomOauth2UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomOauth2UserService customOauth2UserService;
	@Autowired
	private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
	@Autowired
	private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}
	@Bean
	public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
		return new HttpCookieOAuth2AuthorizationRequestRepository();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
					.disable()
				.oauth2Login()
					.authorizationEndpoint()
						.authorizationRequestRepository(cookieAuthorizationRequestRepository())
						.and()
					.userInfoEndpoint()
						.userService(customOauth2UserService)
						.and()
					.successHandler(oAuth2AuthenticationSuccessHandler)
					.failureHandler(oAuth2AuthenticationFailureHandler);
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}