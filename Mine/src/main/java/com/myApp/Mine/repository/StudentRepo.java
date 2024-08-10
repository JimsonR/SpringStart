package com.myApp.Mine.repository;

import com.myApp.Mine.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student,Integer> {
@Query(nativeQuery = true, value = "select student_name from student")
    List<String> selectColumnStudent();

}
