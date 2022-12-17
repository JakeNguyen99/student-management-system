package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student save(Student student);

    Student update(Student student);

    void delete(Long id);
}
