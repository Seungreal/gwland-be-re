package com.leeseungryeol.api.crs.domain;

import com.leeseungryeol.api.usr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

interface ICourseRepository{

}
@Repository
public interface CourseRepository extends JpaRepository<Course,Long>, ICourseRepository {
    List<Course> findAllByUser(User user);
}
