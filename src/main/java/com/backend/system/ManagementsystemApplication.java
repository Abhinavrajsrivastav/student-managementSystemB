package com.backend.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementsystemApplication.class, args);
	}


	@Bean
org.springframework.boot.CommandLineRunner initDatabase(
    com.backend.system.Repo.StudentRepository sRepo, 
    com.backend.system.Repo.DepartmentRepository dRepo) {
    return args -> {
        if (dRepo.count() == 0) {
            com.backend.system.Model.Department cse = dRepo.save(new com.backend.system.Model.Department(null, "Computer Science", null));
            com.backend.system.Model.Department ai = dRepo.save(new com.backend.system.Model.Department(null, "AIML", null));
            
            sRepo.save(new com.backend.system.Model.Student(null, "Demo Student", "demo@test.com", cse));
            System.out.println("✅ Demo data seeded successfully!");
        }
    };
}

}


