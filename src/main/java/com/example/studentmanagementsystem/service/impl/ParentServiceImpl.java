package com.example.studentmanagementsystem.service.impl;

import com.example.studentmanagementsystem.entity.Parent;
import com.example.studentmanagementsystem.repository.ParentRepository;
import com.example.studentmanagementsystem.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Long id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent update(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public void delete(Long id) {
        parentRepository.deleteById(id);
    }
}
