package com.dailylesson.springtdd;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BaseClass {

    @MockBean
    CatRepository catRepository;

    @Autowired
    CatService catService;

    @BeforeEach
    void before(){
        Cat cat = new Cat("Ginger");
        Mockito.when(catRepository.findByName("Ginger")).thenReturn(cat);
        RestAssuredMockMvc.standaloneSetup(new CatRestController(catService));

    }
}
