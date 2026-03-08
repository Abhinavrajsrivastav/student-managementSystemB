package com.backend.system.Controllers;

import org.springframework.web.bind.annotation.*;

import com.backend.system.Model.Student;
import com.backend.system.Repo.StudentRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return repo.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
    }
}