package com.spring.restapi.repositories;

import com.spring.restapi.Domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
