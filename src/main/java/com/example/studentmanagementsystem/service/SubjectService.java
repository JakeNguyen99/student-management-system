package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();

    Subject getSubjectById(Long id);

    Subject save(Subject subject);

    Subject update(Subject subject);

    void delete(Long id);
}
