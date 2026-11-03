package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student registerStudent(@Valid @RequestBody Student student) {
        return service.registerStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return service.findStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        return service.deleteRegistration(id)
                ? "Registration deleted successfully"
                : "Student not found";
    }
}
