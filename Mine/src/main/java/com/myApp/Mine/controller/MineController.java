package com.myApp.Mine.controller;

import com.myApp.Mine.entity.Author;
import com.myApp.Mine.entity.Book;
import com.myApp.Mine.entity.Course;
import com.myApp.Mine.entity.Student;
import com.myApp.Mine.repository.AuthorRepo;
import com.myApp.Mine.repository.BookRepo;
import com.myApp.Mine.repository.CourseRepo;
import com.myApp.Mine.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@RestController
@RequestMapping("/api")
public class MineController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    BookRepo bookRepo;

//    @GetMapping("home")
//    public String studHome(){
//
//        return "home";
//    }


    @GetMapping("/addStudent")
    public void addStudent(@RequestParam("name") String studentName, @RequestParam("id") int id){
        Course course = courseRepo.findById(id).orElse(null);
        Student student = Student.builder().studentName(studentName).course(course).build();
        studentRepo.save(student);
    }

    @GetMapping("/allStudents")
    public List<Student> allStudents(){
      return  studentRepo.findAll();
    }

    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam int id){
        Student student = studentRepo.findById(id).orElse(null);
        return student;
    }

    @GetMapping("/listStuds")
    public List<String> studentList(){
        return studentRepo.selectColumnStudent();
    }

    @GetMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author authorReq){

        Author author = new Author();
        author.setName(authorReq.getName());


        Set<Book> books = new HashSet<>();
        for(Book bookTitle: authorReq.getBooks()){
            Book book = new Book();
            book.setTitle(bookTitle.getTitle());
            book.setAuthor(author);
            books.add(book);
        }
        author.setBooks(books);

        return authorRepo.save(author);
    }


//    @GetMapping("allStudent")
//    public Iterable<Student> allStudents(){
//        return studentRepo.findAll();
//    }
}