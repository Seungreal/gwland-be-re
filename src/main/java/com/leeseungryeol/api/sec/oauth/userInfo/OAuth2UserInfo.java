package com.leeseungryeol.api.sec.oauth.userInfo;

public interface OAuth2UserInfo {
	String getUsername();
	
	String getProviderId();

	String getProvider();

	String getEmail();

	String getAge();

	String getGender();
}
