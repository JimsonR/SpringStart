package com.myApp.Mine.repository;

import com.myApp.Mine.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {

}
