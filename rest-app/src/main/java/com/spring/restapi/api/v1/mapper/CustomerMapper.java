package com.spring.restapi.api.v1.mapper;

import com.spring.restapi.Domain.*;
import com.spring.restapi.api.v1.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER_INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customer);
}
