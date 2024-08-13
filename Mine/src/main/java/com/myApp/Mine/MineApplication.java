package com.myApp.Mine;

import com.myApp.Mine.entity.Student;
import com.myApp.Mine.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.myApp.Mine")

public class MineApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(MineApplication.class, args);

		StudentService service = context.getBean(StudentService.class);

//		service.addCourse("mecs");
//		service.addCourse("mpcs");
//		service.addStudent("jim");


	}
}
