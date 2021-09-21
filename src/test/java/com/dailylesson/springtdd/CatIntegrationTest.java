package com.dailylesson.springtdd;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(properties = "spring.sql.init.mode=always", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class CatIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getCatByNameReturnsCat() {
        Cat cat = this.restTemplate.
                getForObject("/cats/{name}",Cat.class,"Ginger");
        assertThat(cat.getName()).isEqualTo("Ginger");
    }
}
