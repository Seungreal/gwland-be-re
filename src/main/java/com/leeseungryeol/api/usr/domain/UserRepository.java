package com.leeseungryeol.api.usr.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public Optional<User> findByProviderAndProviderId(String provider,String providerId);
}
