package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Parent;

import java.util.List;

public interface ParentService {
    List<Parent> getAllParents();

    Parent getParentById(Long id);

    Parent save(Parent parent);

    Parent update(Parent parent);

    void delete(Long id);
}
