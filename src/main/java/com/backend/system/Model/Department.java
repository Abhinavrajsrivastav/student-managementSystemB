package com.backend.system.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments") // Explicit table naming is better for MySQL
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Ensures you don't get duplicate dept names
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<Student> students;
}