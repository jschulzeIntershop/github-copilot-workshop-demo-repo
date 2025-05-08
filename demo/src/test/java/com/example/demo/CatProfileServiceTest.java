package com.example.demo;

import com.example.demo.entity.CatProfile;
import com.example.demo.repository.CatProfileRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class CatProfileServiceTest {

    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:14.5")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @Autowired
    private CatProfileRepository catProfileRepository;

    @BeforeAll
    public static void setUp() {
        if (!postgresContainer.isRunning()) {
            postgresContainer.start();
        }
    }

    @Test
    public void testGetAllCatProfiles() {
        // Fetch all cat profiles from the repository
        List<CatProfile> profiles = catProfileRepository.findAll();

        // Validate the results
        assertThat(profiles).isNotEmpty();
        assertThat(profiles).hasSize(3);
        assertThat(profiles).extracting("name").contains("Whiskers", "Mittens", "Shadow");
    }

    @AfterAll
    public static void tearDown() {
        postgresContainer.stop();
    }
}