package com.spring.restapi.api.v1.mapper;

import com.spring.restapi.Domain.*;
import com.spring.restapi.api.v1.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDTOtoVendor(VendorDTO vendorDTO);
}
