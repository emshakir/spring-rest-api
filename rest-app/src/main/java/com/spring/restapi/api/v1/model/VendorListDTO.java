package com.spring.restapi.api.v1.model;


import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorListDTO {

    List<VendorDTO> vendors;
}
