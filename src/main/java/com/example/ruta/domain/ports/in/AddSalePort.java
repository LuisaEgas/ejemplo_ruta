package com.example.ruta.domain.ports.in;

import com.example.ruta.domain.models.Sale;

public interface AddSalePort {

    Sale createSale(Sale sale);
}
