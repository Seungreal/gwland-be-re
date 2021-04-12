package com.leeseungryeol.api.crs.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseRepositoryImpl implements ICourseRepository{
    private final JPAQueryFactory qf;
}
