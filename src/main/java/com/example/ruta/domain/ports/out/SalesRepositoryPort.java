package com.example.ruta.domain.ports.out;

import com.example.ruta.domain.models.Sale;

import java.util.List;

public interface SalesRepositoryPort {

    Sale saveSale(Sale sale);
    List<Sale> getSales();

}
