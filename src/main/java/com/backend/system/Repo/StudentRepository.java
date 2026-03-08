package com.backend.system.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.system.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}