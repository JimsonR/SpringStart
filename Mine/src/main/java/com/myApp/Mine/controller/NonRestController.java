package com.myApp.Mine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NonRestController {
//    @Autowired
//    CourseRepo courseRepo;
//    @Autowired
//    StudentRepo studentRepo;


    @RequestMapping("home")
    public String homeReq(){
        return  "home";
    }

//    @GetMapping("addStudent")
//    public void addtudent(@RequestParam("name") String studentName, @RequestParam("id") int id){
//        Course course = courseRepo.findById(id).orElse(null);
//        Student student = Student.builder().studentName(studentName).course(course).build();
//        studentRepo.save(student);
//    }
//
//    @GetMapping("allStudents")
//    public List<Student> allStudents(){
//        return   studentRepo.findAll();
//    }
//
//    @GetMapping("getStudent")
//    public Student getStudent(@RequestParam int id){
//        Student student = studentRepo.findById(id).orElse(null);
//        return student;
//    }

}
