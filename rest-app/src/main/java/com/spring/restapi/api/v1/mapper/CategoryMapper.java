package com.spring.restapi.api.v1.mapper;


import com.spring.restapi.Domain.*;
import com.spring.restapi.api.v1.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
