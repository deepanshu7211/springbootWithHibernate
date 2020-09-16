package com.jpa.hibernate.SpringbootWithJpaHibernate.repository;

import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
}
