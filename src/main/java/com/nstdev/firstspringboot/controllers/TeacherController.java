package com.nstdev.firstspringboot.controllers;

import com.nstdev.firstspringboot.models.ItemKey;
import com.nstdev.firstspringboot.models.Teacher;
import com.nstdev.firstspringboot.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/teachers")
    public String getAllTeacher(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());

        return "teacher/index";
    }
        @GetMapping("/teachers/create")
        public String createTeacher(Model model) {
            List<ItemKey> itemKeylist = new ArrayList<>();
            itemKeylist.add(new ItemKey(1,"ACT","Active"));
            itemKeylist.add(new ItemKey(1,"DEL","Delete"));
            model.addAttribute("ListStatus", itemKeylist);
            model.addAttribute("positions", teacherService.getAllPositions());
            model.addAttribute("teacher", new Teacher());

            return "teacher/form";
        }
    @PostMapping("/teachers/create")
    public String createTeacher(Model model, @ModelAttribute("teacher") Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "redirect:/teachers";

    }

    @GetMapping("/teachers/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        List<ItemKey> itemKeylist = new ArrayList<>();
        itemKeylist.add(new ItemKey(1,"ACT","Active"));
        itemKeylist.add(new ItemKey(1,"DEL","Delete"));
        model.addAttribute("positions", teacherService.getAllPositions());
        model.addAttribute("ListStatus", itemKeylist);
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "teacher/form";
    }
    @GetMapping("/teachers/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }
}
