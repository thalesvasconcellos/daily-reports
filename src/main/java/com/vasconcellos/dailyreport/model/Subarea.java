package com.vasconcellos.dailyreport.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}