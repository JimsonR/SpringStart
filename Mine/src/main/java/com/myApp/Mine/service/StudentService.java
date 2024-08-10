package com.myApp.Mine.service;

import com.myApp.Mine.entity.Course;
import com.myApp.Mine.entity.Student;
import com.myApp.Mine.repository.CourseRepo;
import com.myApp.Mine.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;

    public void addStudent(String name){
        Student student = Student.builder().studentName(name).build();

        studentRepo.save(student);
        System.out.println(studentRepo.findById(2));
    }

    public void addCourse(String name){
        Course course = Course.builder().courseName(name).build();
        courseRepo.save(course);

    }
}
