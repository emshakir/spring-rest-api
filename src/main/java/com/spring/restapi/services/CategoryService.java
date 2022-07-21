package com.spring.restapi.services;

import com.spring.restapi.api.v1.model.*;

import java.util.*;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
