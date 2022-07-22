package com.spring.restapi.repositories;

import com.spring.restapi.Domain.*;
import org.springframework.data.jpa.repository.*;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
