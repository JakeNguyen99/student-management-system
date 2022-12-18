package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Teacher;
import com.example.studentmanagementsystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String listTeacher(Model model){
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String create(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String save(@ModelAttribute("teacher") Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_student";
    }

    @PostMapping("/teachers/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("teacher")  Teacher teacher){
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        teacherService.update(existingTeacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String delete(@PathVariable Long id){
        teacherService.delete(id);
        return "redirect:/teachers";
    }


}
