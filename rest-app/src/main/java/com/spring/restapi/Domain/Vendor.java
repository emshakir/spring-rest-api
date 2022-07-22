package com.spring.restapi.Domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
