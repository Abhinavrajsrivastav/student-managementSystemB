package com.backend.system.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.system.Model.Department;
import com.backend.system.Repo.DepartmentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentRepository repo;
    public DepartmentController(DepartmentRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Department> getAll() { return repo.findAll(); }
    
    @PostMapping
    public Department add(@RequestBody Department dept) { return repo.save(dept); }
}