package com.example.ruta.infrastructure.repositories;

import com.example.ruta.infrastructure.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaSaleRepository extends JpaRepository<SaleEntity, Integer> {

    List<SaleEntity> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
