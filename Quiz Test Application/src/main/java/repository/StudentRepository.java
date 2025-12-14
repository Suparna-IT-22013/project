package com.example.banglaquiz.repository;

import com.example.banglaquiz.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByStudentId(String studentId);
}
