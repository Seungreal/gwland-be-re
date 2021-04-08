package com.leeseungryeol.api.rev.domain;

import com.leeseungryeol.api.pce.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    public List<Review> findByPlace(Place place);
}
