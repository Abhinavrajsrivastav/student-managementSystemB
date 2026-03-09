package com.backend.system.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.system.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}