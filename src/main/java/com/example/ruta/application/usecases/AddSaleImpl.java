package com.example.ruta.application.usecases;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.domain.ports.in.AddSalePort;
import com.example.ruta.domain.ports.out.SalesRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddSaleImpl implements AddSalePort {


    private final SalesRepositoryPort repositoryPort;

    public AddSaleImpl(SalesRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Sale createSale(Sale sale) {
        sale.setCreationDate(LocalDateTime.now());
        return repositoryPort.saveSale(sale);
    }
}
