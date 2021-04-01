package com.leeseungryeol.api.sec.oauth.userInfo;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	private Map<?,?> account;
	private Map<?,?> profile;
	
    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
	    account=(Map<?, ?>) attributes.get("kakao_account");
	    profile=(Map<?, ?>) account.get("profile");}
    
	@Override public String getProviderId() {return String.valueOf(attributes.get("id"));}
	
    @Override public String getEmail() {return (String) account.get("email");}
    
	@Override public String getProvider() {return "kakao";}
	
	@Override public String getAge() {return (String) account.get("age_range");}
	
	@Override public String getGender() {return (String) account.get("gender");}

	@Override public String getUsername() {return (String) profile.get("nickname");}

}
