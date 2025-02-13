package com.tigo.tcs.api.config;


import com.tigo.tcs.api.entity.User;
import com.tigo.tcs.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner seedDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) { 
                List<User> users = List.of(
                    new User("testUser1", "testPass123", "GPT"),
                    new User("testUser2", "securePass456", "POS"),
                    new User("adminUser", "adminSecret", "USD")
                );
                userRepository.saveAll(users);
                System.out.println("Database seeding completed.");
            } else {
                System.out.println("Database already seeded. Skipping...");
            }
        };
    }
}

