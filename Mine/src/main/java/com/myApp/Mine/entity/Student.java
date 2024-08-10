package com.myApp.Mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int studentId;
String studentName;
    @ManyToOne
    @JoinColumn(name="course_id")
    Course course;

}