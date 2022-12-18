package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Parent;
import com.example.studentmanagementsystem.service.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParentController {

    private ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parents")
    public String listParent(Model model){
        model.addAttribute("parents", parentService.getAllParents());
        return "parents";
    }

    @GetMapping("/parents/new")
    public String create(Model model){
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "create_parent";
    }

    @PostMapping("/parents")
    public String save(@ModelAttribute("parent") Parent parent){
        parentService.save(parent);
        return "redirect:/parents";
    }

    @GetMapping("/parents/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("parent", parentService.getParentById(id));
        return "edit_parent";
    }

    @PostMapping("/parents/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("parent") Parent parent){
        Parent existingParent = parentService.getParentById(id);
        existingParent.setFartherName(parent.getFartherName());
        existingParent.setMotherName(parent.getMotherName());
        existingParent.setAddress(parent.getAddress());
        parentService.update(existingParent);
        return "redirect:/parents";
    }

    @GetMapping("/parents/{id}")
    public String delete(@PathVariable Long id){
        parentService.delete(id);
        return "redirect:/parents";
    }
}
