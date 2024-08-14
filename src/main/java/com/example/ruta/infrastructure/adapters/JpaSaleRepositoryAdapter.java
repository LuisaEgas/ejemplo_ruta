package com.example.ruta.infrastructure.adapters;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.domain.ports.out.SalesRepositoryPort;
import com.example.ruta.infrastructure.entities.SaleEntity;
import com.example.ruta.infrastructure.repositories.JpaSaleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaSaleRepositoryAdapter implements SalesRepositoryPort {

    private final JpaSaleRepository jpaSaleRepository;

    public JpaSaleRepositoryAdapter(JpaSaleRepository jpaSaleRepository) {
        this.jpaSaleRepository = jpaSaleRepository;
    }

    @Override
    public Sale saveSale(Sale sale) {
        SaleEntity saleEntity = convertToEntity(sale);
        SaleEntity saveSaleEntity = jpaSaleRepository.save(saleEntity);
        return convertToModel(saveSaleEntity);
    }

    @Override
    public List<Sale> getSales() {
        List<SaleEntity> saleEntities = jpaSaleRepository.findAll();
        return saleEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    private Sale convertToModel(SaleEntity entity) {
        return new Sale(
                entity.getId(),
                entity.getPrice(),
                entity.getCreationDate(),
                entity.getDescription()
        );
    }

    private SaleEntity convertToEntity(Sale model) {
        return new SaleEntity(
                model.getId(),
                model.getPrice(),
                model.getCreationDate(),
                model.getDescription()
        );
    }
}
