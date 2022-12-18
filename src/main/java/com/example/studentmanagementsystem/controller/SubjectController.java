package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Subject;
import com.example.studentmanagementsystem.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String listSubject(Model model){
        model.addAttribute("subjects", subjectService.getAllSubject());
        return "subjects";
    }

    @GetMapping("/subjects/new")
    public String create(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";
    }

    @PostMapping("/subjects")
    public String save(@ModelAttribute("subject") Subject subject){
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("subject", subjectService.getSubjectById(id));
        return "edit_subject";
    }

    @PostMapping("/subjects/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("subject") Subject subject){
        Subject existingSubject = subjectService.getSubjectById(id);
        existingSubject.setSubName(subject.getSubName());
        existingSubject.setChapters(subject.getChapters());
        subjectService.update(existingSubject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/{id}")
    public String delete(@PathVariable Long id){
        subjectService.delete(id);
        return "redirect:/subjects";
    }
}
