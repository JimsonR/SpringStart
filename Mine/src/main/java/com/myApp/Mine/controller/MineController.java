package com.myApp.Mine.controller;

import com.myApp.Mine.entity.Course;
import com.myApp.Mine.entity.Student;
import com.myApp.Mine.repository.CourseRepo;
import com.myApp.Mine.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController

public class MineController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;


//    @GetMapping("home")
//    public String studHome(){
//
//        return "home.jsp";
//
//    }

    @GetMapping("addStudent")
    public void addStudent(@RequestParam("name") String studentName, @RequestParam("id") int id){
        Course course = courseRepo.findById(id).orElse(null);
        Student student = Student.builder().studentName(studentName).course(course).build();
        studentRepo.save(student);
    }

    @GetMapping("allStudents")
    public List<Student> allStudents(){
      return   studentRepo.findAll();
    }

    @GetMapping("getStudent")
    public Student getStudent(@RequestParam int id){
        Student student = studentRepo.findById(id).orElse(null);
        return student;
    }

    @GetMapping("listStuds")
    public List<String> studentList(){
        return studentRepo.selectColumnStudent();
    }



//    @GetMapping("allStudent")
//    public Iterable<Student> allStudents(){
//        return studentRepo.findAll();
//    }
}