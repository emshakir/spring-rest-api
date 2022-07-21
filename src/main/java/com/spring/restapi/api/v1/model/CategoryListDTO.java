package com.spring.restapi.api.v1.model;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
public class CategoryListDTO {

    List<CategoryDTO> categories;

}
