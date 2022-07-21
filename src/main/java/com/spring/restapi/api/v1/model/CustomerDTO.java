package com.spring.restapi.api.v1.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
public class CustomerDTO {
    private String firstname;
    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;
}
