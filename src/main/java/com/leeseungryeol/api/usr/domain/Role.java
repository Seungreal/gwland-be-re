package com.leeseungryeol.api.usr.domain;

public enum Role {
    ADMIN("ROLE_ADMIN", "관리자권한"), USER("ROLE_USER", "사용자권한"), UNKNOWN("UNKNOWN", "알수없는 권한");

    private String code;
    private String description;

    Role(String code,String description){
        this.code = code;
        this.description = description;
    }
}
