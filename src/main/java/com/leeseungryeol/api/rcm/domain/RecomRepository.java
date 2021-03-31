package com.leeseungryeol.api.rcm.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomRepository extends JpaRepository<Recom,Long> {
}
