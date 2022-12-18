package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher);

    void delete(Long id);
}
