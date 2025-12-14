package com.example.banglaquiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String studentId;

    public Student() {}

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) { this.studentId = studentId; }
}
