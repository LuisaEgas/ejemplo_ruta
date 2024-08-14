package com.example.ruta.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    private Integer id;
    private Double price;
    private LocalDateTime creationDate;
    private String description;
}
