package com.example.attendance_system.client;

import com.example.attendance_system.server.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    // Dummy in-memory list instead of database
    List<Student> students = new ArrayList<>();

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, Model model) {

        students.add(student); // store in list

        model.addAttribute("message", "Student Saved Successfully!");
        model.addAttribute("student", new Student()); // reset form

        return "student";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Student> getAllStudents() {
        return students;
    }
}
