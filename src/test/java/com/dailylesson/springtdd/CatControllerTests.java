package com.dailylesson.springtdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class CatControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CatRepository catRepository;

    @Test
    void getCatWithNameShouldReturnCat() throws Exception {
        Cat ginger = new Cat("Ginger");
        BDDMockito.given(catRepository.findByName("Ginger")).willReturn(ginger);
        String expectedValue = this.objectMapper.writeValueAsString(ginger);
        this.mockMvc.perform(get("/cats/{name}","Ginger"))
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .string(expectedValue));

    }
}
