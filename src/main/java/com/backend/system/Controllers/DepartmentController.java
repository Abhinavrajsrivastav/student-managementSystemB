package com.backend.system.Controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.system.Model.Department;
import com.backend.system.Repo.DepartmentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/departments")
public class DepartmentController {
    
    private final DepartmentRepository repo;
    public DepartmentController(DepartmentRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Department> getAll() { 
        return repo.findAll(); 
    }
    
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Department dept) {
        try {
            if (dept.getName() == null || dept.getName().isEmpty()) {
                return ResponseEntity.badRequest().body("Department name is required");
            }
            Department savedDept = repo.save(dept);
            return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error saving department: " + e.getMessage());
        }
    }
}