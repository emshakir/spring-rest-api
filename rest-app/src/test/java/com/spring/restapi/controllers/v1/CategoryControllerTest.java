package com.spring.restapi.controllers.v1;

import com.spring.restapi.api.v1.model.*;
import com.spring.restapi.services.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mock = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    void getAllCategories() throws Exception {

        // Given
        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(1L);
        categoryDTO1.setName("Shakir");

        CategoryDTO categoryDTO2 = new CategoryDTO();
        categoryDTO2.setId(2L);
        categoryDTO2.setName("Other Me");

        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(categoryDTO1, categoryDTO2));

        mock.perform(get("/api/v1/categories/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

    @Test
    void getCategoryByName() throws Exception {

        // Given
        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(1L);
        categoryDTO1.setName("Shakir");

        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO1);
        mock.perform(get("/api/v1/categories/Shakir")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Shakir")));
    }
}