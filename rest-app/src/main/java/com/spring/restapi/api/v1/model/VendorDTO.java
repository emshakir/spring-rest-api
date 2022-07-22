package com.spring.restapi.api.v1.model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;
}
